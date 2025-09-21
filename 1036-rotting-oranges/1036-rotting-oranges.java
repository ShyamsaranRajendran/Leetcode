class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0,n=grid.length,m=grid[0].length;
        Queue<Pair> q= new LinkedList<>();
        int time=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]==1)
                 fresh++;
            }
        }
             
        while(!q.isEmpty() && fresh >0){
            int size=q.size();
            int dirR[]={-1,1,0,0};
            int dirC[]={0,0,-1,1};
            time++;
            for(int i=0;i<size;i++)
            {
                Pair p=q.poll();
                int r=p.a;
                int c=p.b;
                for(int j=0;j<4;j++)
                {
                   int newR= r + dirR[j];
                   int newC= c + dirC[j];
                   if(newR >= 0 && newC >= 0 && newR < n && newC <m  && grid[newR][newC]==1){
                        q.add(new Pair(newR,newC));
                        grid[newR][newC]=2;
                        fresh--;
                   }
                }
            }
        }
        return fresh>0 ? -1 : time;
    }
}