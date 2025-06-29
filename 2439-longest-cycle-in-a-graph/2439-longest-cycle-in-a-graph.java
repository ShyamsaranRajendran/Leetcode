class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[]visited=new boolean[n];
        int maxLen=-1;
        for(int i=0;i<n;i++)
        {
            if(visited[i]) continue;
            int node=i,step=0;
            Map<Integer,Integer> map= new HashMap<>();

            while(node!=-1)
            {
                if(map.containsKey(node))
                {
                    maxLen=Math.max(maxLen,step-map.get(node));
                    break;
                }
                if(visited[node]) break;

                map.put(node,step);
                visited[node]=true;
                node=edges[node];
                step++;
            }

        }
        return maxLen;
    }
}