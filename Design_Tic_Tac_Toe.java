public class TicTacToe {

  int[] rows;
  int[] cols;
  int width;
  int diag1;
  int diag2;
  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    width = n;
    rows = new int[n];
    cols = new int[n];
    diag1 = 0;
    diag2 = 0;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    int v = 0;
    if (player == 1) {
      v = 1;
    } else {
      v = -1;
    }
    rows[row] += v;
    cols[col] += v;
    if (row == col) {
      diag1 += v;
    }
    if (row == width - 1 - col) {
      diag2 += v;
    }
    if (rows[row] == width || cols[col] == width || diag1 == width || diag2 == width) {
      return 1;
    }
    if (rows[row] == -width || cols[col] == -width || diag1 == -width || diag2 == -width) {
      return 2;
    }
    return 0;
  }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
