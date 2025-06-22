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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stk1= new Stack<>();
        Stack<TreeNode> stk2= new Stack<>();
        if(root==null)
         return res;
        stk1.push(root);
        while(!stk1.isEmpty())
        {
          TreeNode cur=stk1.pop();
          stk2.push(cur);
          if(cur.left!=null) stk1.push(cur.left);
          if(cur.right!=null) stk1.push(cur.right);
        }

        while(!stk2.isEmpty())
        {
            res.add(stk2.pop().val);
        }
        return res;
    }
}