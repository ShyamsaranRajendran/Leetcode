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

    void func(TreeNode root,int sum,List<Integer> cur,int target,List<List<Integer>> res)
    {
        if(root==null) return ;
        cur.add(root.val);
        sum+=root.val;
        if(root.left==null && root.right==null && target==sum){
            res.add(new ArrayList<>(cur));
        }
        func(root.left,sum,cur,target,res);
        func(root.right,sum,cur,target,res);

        cur.remove(cur.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res= new ArrayList<>();
        func(root,0,new ArrayList<>(),targetSum,res);
        return res;

    }
}