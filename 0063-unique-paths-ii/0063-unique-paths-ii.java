class Solution {
    int func(int i,int j,int grid[][],int dp[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==1){
            return 0;
        }

        if(i==n-1 && j==m-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down= func(i,j+1,grid,dp);
        int right = func(i+1,j,grid,dp);

        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n+1][m+1];

        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int res= func(0,0,obstacleGrid,dp);
        return res;
    }
}