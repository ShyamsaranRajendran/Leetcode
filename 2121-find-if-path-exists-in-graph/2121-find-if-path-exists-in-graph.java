class Solution {
    public ArrayList<ArrayList<Integer>> BuildGraph(int n, int grid[][])
    {
         ArrayList<ArrayList<Integer>> adj= new ArrayList<>();

         for(int i=0;i<n;i++) adj.add(new ArrayList<>());

         for(int []edge : grid)
        {
           adj.get(edge[0]).add(edge[1]);
           adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> vis= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj= BuildGraph(n,edges);
        q.add(source);
        vis.add(source);

        while(! q.isEmpty())
        {
           int p = q.poll();
           
           if(p== destination)
           {
            return true;
           }

           for(int i : adj.get(p)){
            if(!vis.contains(i))
            {
                q.add(i);
                vis.add(i);
            }
           }
        }
        return false;
    }
}