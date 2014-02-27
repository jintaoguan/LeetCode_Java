public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        if( m == 0 ) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for( int i = 0; i < m; ++i )
        {
            for( int j = 0; j < n; ++j )
            {
                if( i == 0 && j == 0 ) continue;
                int left = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if( j != 0 ) left = dp[i][j-1];
                if( i != 0 ) up = dp[i-1][j];
                dp[i][j] = Math.min( left, up ) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
