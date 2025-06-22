class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isOdd = false;  // Root is level 0 (even)

        while (!q.isEmpty()) {
            int n = q.size();
            List<TreeNode> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                level.add(node);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (isOdd) {
                for (int i = 0; i < level.size() / 2; i++) {
                    int temp = level.get(i).val;
                    level.get(i).val = level.get(level.size() - 1 - i).val;
                    level.get(level.size() - 1 - i).val = temp;
                }
            }

            isOdd = !isOdd; // flip level flag
        }

        return root;
    }
}
