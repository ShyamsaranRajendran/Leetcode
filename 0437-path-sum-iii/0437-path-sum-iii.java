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
     Map<Long,Integer> map= new HashMap<>();
     map.put(0L,1);
     return dfs(root,0,targetSum,map); 
    }

    int dfs(TreeNode root,long cursum,int target,Map<Long,Integer> map)
    {
        if(root == null)
           return 0;
        cursum+=root.val;
        long diff=cursum-target;
        int count= map.getOrDefault(diff,0);

map.put(cursum, map.getOrDefault(cursum, 0) + 1);

        count+=dfs(root.left,cursum,target,map);
        count+=dfs(root.right,cursum,target,map);

        map.put(cursum,map.get(cursum)-1);

        return count;    
    }

}
