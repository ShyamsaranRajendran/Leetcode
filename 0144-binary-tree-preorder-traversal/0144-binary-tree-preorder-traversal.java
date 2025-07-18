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
    void func(List<Integer> list, TreeNode root)
    {
        if(root==null)
           return ;
        list.add(root.val);
        func(list,root.left);
        func(list,root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        // Stack<TreeNode> stk=new Stack<>();
        // TreeNode cur=root;
        // if(root==null)
        // {
        //     return res;
        // }
        // stk.push(root);
        // while(!stk.isEmpty())
        // {
        //     cur=stk.pop();
        //     res.add(cur.val);
        //     if(cur.right!=null) stk.push(cur.right);
        //     if(cur.left!=null) stk.push(cur.left);
        // }
        func(res,root);
        return res;
    }
}