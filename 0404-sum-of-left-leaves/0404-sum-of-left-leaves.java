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
    public TreeNode root;
    public boolean is_left;
    Pair(TreeNode root,boolean is_left)
    {
        this.root=root;
        this.is_left=is_left;
    }
 }

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> q= new LinkedList<>();
        if(root==null)
           return 0;
        q.add(new Pair(root,false));
        int sum=0;
        while(!q.isEmpty())
        {
            int n=q.size();

            for(int i=0;i<n;i++)
            {
                Pair p=q.poll();
                TreeNode t=p.root;
                if(p.is_left && t.left ==null && t.right==null)
                {
                    sum+=t.val;
                }
                if(t.left!=null) q.offer( new Pair(t.left,true));
                if(t.right!=null) q.offer(new Pair(t.right,false));
            }
        }
        return sum;

    }
}