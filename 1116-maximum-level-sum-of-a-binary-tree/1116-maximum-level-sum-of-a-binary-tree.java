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
    public int maxLevelSum(TreeNode root) {
        int max=(int)-1e9;
        int level=1,Anslevel=0;
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null)
         return 0;
        q.offer(root);
        while(!q.isEmpty())
        {

           int n=q.size();
           int total=0;
           for(int i=0;i<n;i++)
           {

            TreeNode cur= q.poll();
            total+=cur.val;

            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
           
           }
           if(max < total)
           {
             Anslevel=level;
             max=total;
           }
           
           level++;
        }
        return Anslevel;

    }
}