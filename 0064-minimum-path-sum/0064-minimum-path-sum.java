class Solution {
    int func(int i,int j,int grid[][],int dp[][]){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n ||j>=m){
            return Integer.MAX_VALUE;
        }
        if(i==n-1 &&j==m-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = func(i+1,j,grid,dp);
        int right = func(i,j+1,grid,dp);

        return dp[i][j]=grid[i][j] + Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        int res=func(0,0,grid,dp);
        return res;
    }
}