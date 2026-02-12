import java.util.Arrays;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        // fill dp with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(text1, text2, 0, 0, dp);
    }

    private int helper(String t1, String t2, int i, int j, int[][] dp) {

        // base case
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }

        // already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // match case
        if (t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + helper(t1, t2, i + 1, j + 1, dp);
        } 
        // not match
        else {
            int skipT1 = helper(t1, t2, i + 1, j, dp);
            int skipT2 = helper(t1, t2, i, j + 1, dp);
            dp[i][j] = Math.max(skipT1, skipT2);
        }

        return dp[i][j];
    }
}
