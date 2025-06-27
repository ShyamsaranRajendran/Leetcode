class Solution {
     int func(int i,int j,int grid[][],int dp[][])
    {
        int n=dp.length,m=dp[0].length;
        if(i<0 ||j<0 || j>=m || i>=n || grid[i][j]==1)
        {
            return 0;
        }
        if(i==n-1 && j==m-1)
        {
            return 1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int down= func(i+1,j,grid,dp);
        int right= func(i,j+1,grid,dp);

        return dp[i][j]= down+right;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length,m=obstacleGrid[0].length;
           int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
           Arrays.fill(dp[i],-1);
        int ans= func(0,0,obstacleGrid,dp);
        return ans;
    }
}