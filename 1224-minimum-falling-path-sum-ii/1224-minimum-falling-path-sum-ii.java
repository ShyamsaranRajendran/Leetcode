class Solution {

    int func(int i,int j,int[][]grid,int dp[][])
    {
        int n=grid.length,m=grid[0].length;
        if(j>=m || i>=n)
            return (int)1e9;
        if(i==n-1)
             return grid[i][j];
        if(dp[i][j]!=(int)1e9)
           return dp[i][j];
        int minValue = Integer.MAX_VALUE;
        for(int k=0;k<m;k++)
        {
            if(k!=j)
            {
                minValue = Math.min(minValue,func(i+1,k,grid,dp)); 
            }
        }

        return dp[i][j]=grid[i][j]+minValue;
        
    }
    public int minFallingPathSum(int[][] grid) {
      int n= grid.length,m=grid.length;

      int dp[][]=new int[n][m];
      for(int i=0;i<n;i++)
       Arrays.fill(dp[i],(int)1e9);
      int ans= (int)1e9;
      for(int i=0;i<n;i++)
      {
        ans=Math.min(ans,func(0,i,grid,dp));
      }  
      return ans;
    }
}