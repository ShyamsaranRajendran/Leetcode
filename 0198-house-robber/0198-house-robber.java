class Solution {
    public int func(int i,int []nums,int[]dp)
    {
        int n=nums.length;
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int pick= nums[i] + func(i+2,nums,dp);
        int skip = func(i+1,nums,dp);
        return dp[i]=Math.max(pick,skip);
    }
    public int rob(int[] nums) {
        int n= nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        int res=func(0,nums,dp);
        return res;
    }
}