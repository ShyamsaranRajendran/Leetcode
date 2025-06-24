/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
     void NPreOrder(Node root,List<Integer> res)
     {
        if(root==null)
         return;
        res.add(root.val);
        for(Node n : root.children)
           NPreOrder(n,res);

     }
    public List<Integer> preorder(Node root) {
        List<Integer> l= new ArrayList<>();
         if(root==null)
            return l;
        NPreOrder(root,l);
        return l;
    }
}