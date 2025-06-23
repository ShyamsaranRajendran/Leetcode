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
    int max=(int)-1e9;
    int sum(TreeNode root)
    {
       if(root==null) return 0;

       int left=Math.max(0,sum(root.left));
       int right=Math.max(0,sum(root.right));

       max=Math.max(max,root.val+left+right);

       return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int  ans = sum(root);
        return max;
    }
}