class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();

        int n=numCourses;
        for(int i=0;i<n;i++) list.add(new ArrayList<>());

        int indegree[]=new int[n];
        for(int edge[]:prerequisites){
            list.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q= new LinkedList<>();
        boolean vis[]=new boolean[n];

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo=new ArrayList<>();

        while(!q.isEmpty()){
           int u=q.poll();
           topo.add(u);

           for(int i:list.get(u)){
            indegree[i]--;
            if(indegree[i]==0)
            {
                q.add(i);
            }
           }
        }

        return topo.size()==n;
    }
}