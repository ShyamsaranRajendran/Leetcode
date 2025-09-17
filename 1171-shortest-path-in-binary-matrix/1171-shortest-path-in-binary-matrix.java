class Pair{
    int r, c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }

        Queue<Pair> q=new LinkedList<>();
        boolean vis[][]=new boolean[n][m];
        int len=1;
        q.add(new Pair(0,0));
        vis[0][0]=true;
        int dirR[]= {-1, -1, -1, 0, 1, 1, 1, 0};
        int dirC[]= {-1, 0, 1, 1, 1, 0, -1, -1};

        while(!q.isEmpty()){
            int size=q.size();

            for (int s = 0; s < size; s++) {
            Pair p= q.poll();
            int cr=p.r;
            int cc=p.c;

            if(cr==n-1 && cc==m-1) return len;

            for(int i=0;i<8;i++){
                int newrow = cr+dirR[i];
                int newcol = cc+dirC[i];
                if(newrow>=0 && newrow <n && newcol >=0  && newcol <m &&
                 !vis[newrow][newcol] && grid[newrow][newcol]!=1){
                    q.add(new Pair(newrow,newcol));
                    vis[newrow][newcol]=true;
                 }
            }
            }
            len++;
        }

        return -1;
    }
}