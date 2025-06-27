class Solution {
    int func(int i,int j,int[][]grid,int dp[][])
    {
        int n=grid.length,m=grid[0].length;

        if (j < 0 || j >= m) return Integer.MAX_VALUE;

        if (i == n - 1) return grid[i][j];
        
        if(dp[i][j]!=-1)
           return dp[i][j];
        int dia1= func(i+1,j-1,grid,dp);
        int down= func(i+1,j,grid,dp);
        int dia2= func(i+1,j+1,grid,dp);

        return dp[i][j] = grid[i][j] + Math.min(dia1,Math.min(down,dia2));


    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int dp[][]= new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans=(int)1e9;

        // for(int i=0;i<m;i++)
        // {
        //   ans=Math.min(ans,func(0,i,matrix,dp));
        // }

        for(int i=0;i<m;i++)
        {
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
               int left= (i>0 && j>0) ? dp[i-1][j-1] : (int)1e9;
               int right= (j<m-1) ? dp[i-1][j+1]:(int)1e9;
               int down=(i>0) ? dp[i-1][j] : (int)1e9;

               dp[i][j]=matrix[i][j] + Math.min(down,Math.min(left,right));
            }
        }
        int MaxSum=(int)1e9;
        for(int i=0;i<m;i++)
        {
            MaxSum=Math.min(MaxSum,dp[n-1][i]);
        }

        return MaxSum;
    }
}