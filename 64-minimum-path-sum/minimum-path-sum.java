class Solution {

    public int helper(int[][] grid, int i, int j, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (i >= n || j >= m) return Integer.MAX_VALUE;

        // Destination
        if (i == n - 1 && j == m - 1) return grid[i][j];

        // Memo check
        if (dp[i][j] != -1) return dp[i][j];

        int right = helper(grid, i, j + 1, dp);
        int down  = helper(grid, i + 1, j, dp);

        dp[i][j] = grid[i][j] + Math.min(right, down);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        // Fill with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(grid, 0, 0, dp);
    }
}
