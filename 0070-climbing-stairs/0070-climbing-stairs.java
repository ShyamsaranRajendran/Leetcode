class Solution {
    int func(int i,int dp[]){
        if(i==0) return 1;
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=func(i-1,dp) + func(i-2,dp);
    }
    public int climbStairs(int n) {
        int ans=0;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        ans=func(n,dp);
        return ans;
    }
}