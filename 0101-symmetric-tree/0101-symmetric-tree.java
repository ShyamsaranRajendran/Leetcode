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
    public boolean check(TreeNode root,TreeNode root1){
        if(root==null && root1==null) return true;
        if(root==null || root1==null || root.val!=root1.val) return false;
        return check(root.left,root1.right) && check(root.right,root1.left);
    }
    public boolean isSymmetric(TreeNode root) {
        boolean ans=check(root.left,root.right);
        return ans;
    }
}