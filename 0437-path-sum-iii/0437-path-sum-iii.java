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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        int count = func(root,targetSum);

        count+= pathSum(root.left,targetSum);
        count+= pathSum(root.right,targetSum);

        return count;
    }

    public int func(TreeNode root,long sum){
        if(root==null) return 0;

        int count=0;
        
        if(sum==root.val)
            count++;

        count+= func(root.left,sum-root.val);
        count+= func(root.right,sum-root.val);

        return count;
    }

   
}
