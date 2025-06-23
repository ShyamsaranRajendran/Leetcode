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
   
    
     public static void graph(TreeNode node,TreeNode parent,Map<TreeNode,List<TreeNode>> map)
    {
        if(node == null)
           return ;
         
        map.putIfAbsent(node,new ArrayList<>());
        if(parent != null)
        {
            map.get(node).add(parent);
            map.get(parent).add(node);
        }
        
        graph(node.left,node,map);
        graph(node.right,node,map);
    }
     public static TreeNode FindTarget(int target,TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==target)
        {
            return root;
        }
        TreeNode t1=FindTarget(target,root.left);
        if(t1!=null)
          return t1;
        TreeNode t2= FindTarget(target,root.right);
        if(t2!=null)
           return t2;
        return null;
    }

    public int amountOfTime(TreeNode root, int start) {
       Map<TreeNode,List<TreeNode>> map= new HashMap<>();
       graph(root,null,map);
       Queue<TreeNode> q= new LinkedList<>();
       Set<TreeNode> set= new HashSet<>();
       TreeNode Fired=FindTarget(start,root);
       q.add(Fired);
       set.add(Fired);
       int sec=0;
       while(!q.isEmpty())
       {
          int n=q.size();
          sec++;
          for(int i=0;i<n;i++)
          {
              TreeNode temp=q.poll();
              for(TreeNode fire:map.get(temp))
              {
                  if(!set.contains(fire))
                  {
                      set.add(fire);
                      q.add(fire);
                  }
              }
          }
       }
       return sec-1;
       
       
    }
}