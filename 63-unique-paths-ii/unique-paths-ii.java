class Solution {

    public int helper(int[][] grid, int i, int j, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // out of bounds
        if (i >= n || j >= m) return 0;

        // obstacle
        if (grid[i][j] == 1) return 0;

        // destination
        if (i == n - 1 && j == m - 1) return 1;

        // memo check
        if (dp[i][j] != -1) return dp[i][j];

        int right = helper(grid, i, j + 1, dp);
        int down  = helper(grid, i + 1, j, dp);

        dp[i][j] = right + down;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        // fill -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(obstacleGrid, 0, 0, dp);
    }
}
