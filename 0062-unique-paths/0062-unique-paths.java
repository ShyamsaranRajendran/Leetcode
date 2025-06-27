class Solution {
    int func(int i,int j,int dp[][])
    {
        int n=dp.length,m=dp[0].length;
        if(i<0 ||j<0 || j>=m || i>=n)
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
        
        int down= func(i+1,j,dp);
        int right= func(i,j+1,dp);

        return dp[i][j]= down+right;

    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)
           Arrays.fill(dp[i],-1);
        int ans= func(0,0,dp);
        return ans;
    }
}