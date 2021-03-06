/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
  private List<NestedInteger> nestedList;
  private int data;
  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedList = nestedList;
  }

  @Override
  public Integer next() {
    return data;
  }

  @Override
  public boolean hasNext() {
    while(nestedList != null && nestedList.size() > 0){
      NestedInteger tmpInt = nestedList.remove(0);
      if(tmpInt.isInteger()){
        data = tmpInt.getInteger();
        return true;
      }else{
        nestedList.addAll(0,tmpInt.getList());
      }
    }
    return false;
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
