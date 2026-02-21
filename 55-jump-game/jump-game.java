class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is beyond what we can reach
            if (i > farthest) {
                return false;
            }

            // Update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}