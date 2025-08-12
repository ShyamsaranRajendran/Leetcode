class Solution {
    private int MOD = 1_000_000_007;
    public int dfs(int cur,int n,int x,int dp[][])
    {
        int pow = (int) Math.pow(cur,x);

        if(pow > n)  return 0;
        if(pow == n) return 1;
        if(dp[cur][n]!=-1) return dp[cur][n];
        int take=dfs(cur+1,n-pow,x,dp);
        int skip=dfs(cur+1,n,x,dp);

        return dp[cur][n] = (int) (((long) take + skip) % MOD);
    }
    public int numberOfWays(int n, int x) {
        int dp[][]=new int[n+1][n+1];
        for(int i[] :dp){
            Arrays.fill(i,-1);
        }
        return dfs(1,n,x,dp);
    }
}