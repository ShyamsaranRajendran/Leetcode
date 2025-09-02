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
    void func(TreeNode root,ArrayList<Integer> list,String temp){
        if(root == null){
           return;
        }

        temp=temp + root.val;
        
        if (root.left == null && root.right == null) {
            list.add(Integer.parseInt(temp));
            return;
        }

        func(root.left, list, temp);
        func(root.right, list, temp);

    }
    public int sumNumbers(TreeNode root) {
        int res=0;

        if(root == null) return 0;
        ArrayList<Integer> list= new ArrayList<>();
        func(root,list,new String());
        for(int i:list){
            res+=i;
        }
        return res;
    }
}