class Solution {
    
    private int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private tuple helper(TreeNode node) {
        if (node == null) {
            return new tuple(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        tuple left = helper(node.left);
        tuple right =helper(node.right);
        
        if (left.isBST && right.isBST 
                && node.val > left.max 
                && node.val < right.min) {
            
            int currentSum = left.sum + right.sum + node.val;
            maxSum = Math.max(maxSum, currentSum);
            
            int min = Math.min(left.min, node.val);
            int max = Math.max(right.max, node.val);
            
            return new tuple(true, min, max, currentSum);
        }
        
        return new tuple(false, 0, 0, 0);
    }
    
    private static class tuple {
        boolean isBST;
        int min;
        int max;
        int sum;
        
        tuple(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
}