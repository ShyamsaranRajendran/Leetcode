class Solution {
    int func(int jump,int n,int dp[])
    {
        if(jump==n)
            return 1;
        if(jump>n)
            return 0;
        if(dp[jump]!=-1)
            return dp[jump];
        int one=func(jump+1,n,dp);
        int two=func(jump+2,n,dp);
        return dp[jump]=one+two;
    }
    public int climbStairs(int n) {
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int res= func(0,n,dp);
        return res;
    }
}