class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        // total sum
        for (int num : nums) {
            sum += num;
        }

        // if odd sum → cannot partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        // ----- DP INITIALIZATION -----
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   // sum 0 is always possible
        // ----------------------------

        // fill dp
        for (int num : nums) {
            for (int s = target; s >= num; s--) {
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[target];
    }
}
