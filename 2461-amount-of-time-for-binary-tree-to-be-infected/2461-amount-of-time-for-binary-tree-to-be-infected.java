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
    static int maxTime = 0;

     public int amountOfTime(TreeNode root, int start)  {
        maxTime = 0;
        dfs(root, start);
        return maxTime;
    }

    static int dfs(TreeNode node, int target) {
        if (node == null) return -1;

        if (node.val == target) {
            maxDepth(node, 0);
            return 1; 
        }

        int left = dfs(node.left, target);
        if (left != -1) {
         
            maxDepth(node.right, left+1);
            maxTime = Math.max(maxTime, left);
            return left + 1;
        }

        int right = dfs(node.right, target);
        if (right != -1) {
       
            maxDepth(node.left, right+1);
            maxTime = Math.max(maxTime, right);
            return right + 1;
        }

        return -1;
    }

    static void maxDepth(TreeNode node, int time) {
        if (node == null) return;
        maxTime = Math.max(maxTime, time);
        maxDepth(node.left, time + 1);
        maxDepth(node.right, time + 1);
    }
}