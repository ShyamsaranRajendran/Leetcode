/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        
        if(root ==null) return list;
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();

            List<Integer> temp =  new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode p= q.poll();
                 if(p.left != null){
                    q.add(p.left);
                }
                
                if(p.right != null){
                    q.add(p.right);
                }
               
                temp.add( p.val);
            }

            list.add(temp);
        }

        return list;
    }
}