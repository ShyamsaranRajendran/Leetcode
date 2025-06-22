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

    TreeNode dfs(TreeNode root)
    {
        if(root==null || ContainsNoOne(root) )
        {
           return null;
        }  
        root.left=dfs(root.left);
        root.right=dfs(root.right);

        return root;
    }

    boolean ContainsNoOne(TreeNode root)
    {
        if(root==null)
            return true;
        if(root.val==1)
            return false;
        return ContainsNoOne(root.left) && ContainsNoOne(root.right);
    }
    public TreeNode pruneTree(TreeNode root) {
        root=dfs(root);
        return root;
    }
}