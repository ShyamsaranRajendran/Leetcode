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

    int Height(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(Height(root.left),Height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}