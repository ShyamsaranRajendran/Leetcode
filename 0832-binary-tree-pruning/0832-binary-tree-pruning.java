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

    

    boolean ContainsNoOne(TreeNode root)
    {
        if(root==null)
            return true;
        if(root.val==1)
            return false;
        return ContainsNoOne(root.left) && ContainsNoOne(root.right);
    }

    public TreeNode pruneTree(TreeNode root) {
       
       Queue<TreeNode> q= new LinkedList<>();
       if(root==null)
        return root;
       if(ContainsNoOne(root))
       {
          return null;
       }
       q.add(root);
       while(!q.isEmpty())
       {
        TreeNode t=q.poll();
        if(ContainsNoOne(t.left))
        {
            t.left=null;
        }else{
            q.add(t.left);
        }
        if(ContainsNoOne(t.right))
        {
            t.right=null;
        }else{
            q.add(t.right);
        }
       }

        return root;
    }
}