class Pair{
    int r,c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]==color) return image;

        int n=image.length;
        int m=image[0].length;

        boolean vis[][]=new boolean[n][m];
        Queue<Pair> q= new LinkedList<>();
        
        int dirR[]={-1,0,0,1};
        int dirC[]={0,-1,1,0};
        int startcolor= image[sr][sc];
        q.add(new Pair(sr,sc));
        image[sr][sc]=color;
        vis[sr][sc]=true;
        while(!q.isEmpty()){
           
               Pair p=q.poll();
               int cr=p.r;
               int cc=p.c;
               for(int j=0;j<4;j++){
                   int newrow = cr + dirR[j];
                   int newcol = cc + dirC[j];

                   if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && 
                   !vis[newrow][newcol] && image[newrow][newcol]==startcolor){
                    image[newrow][newcol]=color;
                    q.add(new Pair(newrow,newcol));
                    vis[newrow][newcol]=true;
                   }
               }
        }
        return image;
    }
}