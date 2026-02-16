class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Use a Set to store values we have already visited
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) return false;

        // Check if the number we need to reach k is already in the set
        int complement = k - node.val;
        if (set.contains(complement)) {
            return true;
        }

        // Add current value to the set and keep looking in both directions
        set.add(node.val);
        
        return helper(node.left, k, set) || helper(node.right, k, set);
    }
}