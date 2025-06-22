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
 class Pair{
   public  TreeNode root;
   public  int index;
    Pair(TreeNode root,int ind)
    {
        this.root=root;
        index=ind;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        Queue<Pair> q= new LinkedList<>();
        if(root==null)
         return ans;
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
          int n=q.size();
          int minValue=q.peek().index;
          int first=0,last=0;

          for(int i=0;i<n;i++)
          {
            Pair p= q.poll();
            TreeNode t=p.root;
            int ind=p.index-minValue;

            if(i==0) first=ind;
            if(i==n-1) last=ind;

            if(t.left!=null)
              q.offer(new Pair(t.left,2*ind));
            if(t.right!=null)
               q.offer(new Pair(t.right,2*ind -1));
          }

          ans=Math.max(ans,first-last+1);
        }
        return ans;
        
    }
}