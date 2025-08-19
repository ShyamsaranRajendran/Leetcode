class Solution {

    int func(int i,int j,int n,int m,int dp[][]){
        if(i<0 || j<0 || i>n||j>m){
            return 0;
        }

        if(i==n-1 && j==m-1){
            return 1;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int down = func(i,j+1,n,m,dp);
        int right = func(i+1,j,n,m,dp);

        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
       int dp[][]=new int[m+1][n+1];
       for(int i[]:dp){
        Arrays.fill(i,-1);
       }
       int res=func(0,0,m,n,dp);
       return res;
    }
}