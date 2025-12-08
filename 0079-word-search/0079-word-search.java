class Solution {

    public boolean func(int i,int j,char board[][],boolean vis[][],String target,int ind){
        if(target.length()==ind){
            return true;
        }

        if(i>= board.length || j>= board[0].length || i<0 || j<0 || board[i][j]!=target.charAt(ind) || vis[i][j]){
            return false;
        }

        vis[i][j]=true;
        ind++;

        boolean found = (func(i+1,j,board,vis,target,ind)
        || func(i,j+1,board,vis,target,ind) 
        ||func(i-1,j,board,vis,target,ind) 
        ||func(i,j-1,board,vis,target,ind));

        vis[i][j]=false;

        return found;
    }
    public boolean exist(char[][] board, String word) {
        boolean res;
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        int ind=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(func(i,j,board,vis,word,ind)){
                    return true;
                }
            }
        }
        return false;
    }
}