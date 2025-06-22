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
    
    void graph(TreeNode node , TreeNode parent,Map <TreeNode,List<TreeNode>> map)
    {
        if(node==null)
           return ;
        map.putIfAbsent(node , new ArrayList<>());

        if(parent !=null)
        {
            map.get(node).add(parent);
            map.get(parent).add(node);
        }

        graph(node.left,node,map);
        graph(node.right,node,map);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> list= new ArrayList<>();
        Map<TreeNode,List<TreeNode>> map= new HashMap<>();
        graph(root,null,map);
 
        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int d=0;

        while(!q.isEmpty()){
            int size=q.size();
            
            if(d==k)
             break;
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
              for(TreeNode t: map.get(temp))
              {
                 if(!set.contains(t))
                 {
                   set.add(t);
                   q.add(t);
                  }
               }
            }
            d++;
        }

        while(!q.isEmpty())
        {
            list.add(q.poll().val);
        }

        return list;
    }
}