class Solution {
    int func(int i,int n,int nums[],int dp[])
    {
        if(i>=n){
           return 0;
        }

        if(dp[i]!=-1)
            return dp[i];
        
        int pick=nums[i] + func(i+2,n,nums,dp);
        int notpick=func(i+1,n,nums,dp);

        return dp[i] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=func(0,nums.length -1 , nums,dp);
        Arrays.fill(dp,-1);
        int res=Math.max(ans,func(1,nums.length,nums,dp));

        return res;
    }
}