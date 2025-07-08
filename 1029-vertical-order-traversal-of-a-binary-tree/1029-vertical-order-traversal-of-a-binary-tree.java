class Solution {

    // Helper class to store node with its horizontal and vertical level
    class Tuple {
        TreeNode node;
        int hd;     // horizontal distance
        int level;  // vertical level

        Tuple(TreeNode n, int h, int l) {
            node = n;
            hd = h;
            level = l;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to sort by horizontal distance (left to right)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // Queue for BFS traversal
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // Start with root at hd=0, level=0

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int hd = t.hd;
            int level = t.level;

            // Insert value into map
            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());
            map.get(hd).get(level).offer(node.val);

            // Add left and right children
            if (node.left != null)
                q.offer(new Tuple(node.left, hd - 1, level + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, hd + 1, level + 1));
        }

        // Build final result
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levels.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            res.add(col);
        }

        return res;
    }
}
