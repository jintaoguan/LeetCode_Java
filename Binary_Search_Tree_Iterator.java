/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1.
public class BSTIterator {
  Stack<TreeNode> stack;
  public BSTIterator(TreeNode root) {
    stack = new Stack<TreeNode>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    int ret = node.val;
    if (node.right != null) {
      node = node.right;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
    return ret;
  }
}

// Solution 2.
public class BSTIterator {
  private List<TreeNode> nodes;
  private int cur;
  public BSTIterator(TreeNode root) {
    nodes = new ArrayList<TreeNode>();
    inorderTraversal(root, nodes);
    cur = 0;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return cur < nodes.size();
  }

  /** @return the next smallest number */
  public int next() {
    int res = nodes.get(cur).val;
    cur++;
    return res;
  }

  private void inorderTraversal(TreeNode root, List<TreeNode> inorder) {
    if (root != null) {
      inorderTraversal(root.left, inorder);
      inorder.add(root);
      inorderTraversal(root.right, inorder);
    }
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
