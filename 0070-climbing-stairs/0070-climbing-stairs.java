class Solution {

    int func(int i,int n,int dp[]){
        if(i==n)
           return 1;
        if(i>n)
           return 0;
        if(dp[i]!=-1)
           return dp[i];
        int oneway=func(i+1,n,dp);
        int secondway=func(i+2,n,dp);
        return dp[i]=oneway+secondway;
    }
    public int climbStairs(int n) {
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        int res= func(0,n,dp);
        return res;
    }
}