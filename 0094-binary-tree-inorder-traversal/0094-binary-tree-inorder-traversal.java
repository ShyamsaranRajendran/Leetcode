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
   
   void func(TreeNode root,List<Integer> list ){
    if(root==null)
    {
        return;
    }
    func(root.left,list);
    list.add(root.val);
    func(root.right,list);
   }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        func(root,list);
        return list;
    }
}