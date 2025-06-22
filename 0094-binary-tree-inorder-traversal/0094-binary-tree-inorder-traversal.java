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
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stk=new Stack<>();
    TreeNode cur=root;
    while(cur!=null || !stk.isEmpty())
    {
        while(cur!=null)
        {
            stk.push(cur);
            cur=cur.left;
        }

        cur=stk.pop();
        result.add(cur.val);
        cur=cur.right;
    }
    return result;
    }
}