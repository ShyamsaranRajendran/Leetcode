/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    boolean findPath(TreeNode root,TreeNode target,List<TreeNode> path)
    {
        if(root==null) return false;
         path.add(root);
        if(root==target) return true;
        if(findPath(root.left,target,path)||findPath(root.right,target,path)) return true;
        path.remove(path.size()-1);
        return false;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1= new ArrayList<>();
        List<TreeNode> p2= new ArrayList<>();

        findPath(root,p,p1);
        findPath(root,q,p2);
        TreeNode lca=null;
        int i=0;
        while(i<Math.min(p1.size(),p2.size())){
            if(p1.get(i)==p2.get(i))
            {
                lca=p1.get(i);
                i++;
            }else{
                break;
            }
        }
        return lca;
      
    }
}

