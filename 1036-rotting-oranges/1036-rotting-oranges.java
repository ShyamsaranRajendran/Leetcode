class Pair{
    int first,second;
    Pair(int a,int b)
    {
        first=a;
        second=b;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0;
        int cntfresh=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j));
                }else if(grid[i][j]==1)
                {
                    cntfresh++;
                }
            }
        }
        
        int dirR[]={-1,1,0,0};
        int dirC[]={0,0,-1,1};

        while(!q.isEmpty() && cntfresh >0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
          Pair p=q.poll();
          int row=p.first;
          int col=p.second;

          for(int j=0;j<4;j++)
          {
            int newrow=row+dirR[j];
            int newcol=col+dirC[j];

            if(newrow >=0&& newrow <n && newcol>=0 && newcol<m && grid[newrow][newcol]==1)
            {
                grid[newrow][newcol]=2;
                q.add(new Pair(newrow,newcol));
                cntfresh--;
            }
          }
            }
          time++;
        }
        return cntfresh==0 ? time : -1;
    }
}