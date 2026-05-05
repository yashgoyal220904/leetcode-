class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return result;

        int flag = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int lvl = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();

            if (flag == 0) {
                for (int i = 0; i < lvl; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);

                    subList.addLast(node.val);
                }
                flag = 1;

            } else {
                for (int i = 0; i < lvl; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);

                    subList.addFirst(node.val);
                }
                flag = 0;
            }

            result.add(subList);
        }

        return result;
    }
}
