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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();

        if(root==null) return 0;
        q.add(root);
        
        int count = 1;

        while(!q.isEmpty())
        {
           int  size= q.size();
           for(int i=0;i<size;i++){
                 TreeNode p=q.poll();
                 if(p.right==null && p.left==null){
                    return count;
                 }

                 if( p.right!=null){
                    q.add( p.right);
                 }
                 if( p.left!=null){
                    q.add(p.left);
                 }
           }
           count++;
        }

        return 0;

    }
}