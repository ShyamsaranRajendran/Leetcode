class Solution {
    
    int func(int i,int prev,int []nums,int[][]dp)
    {
        if(i==nums.length)
        {
            return 0;
        }
        if(dp[i][prev+1]!=-1)
        {
            return dp[i][prev+1];
        }
        int nottake=func(i+1,prev,nums,dp);
        int take=0;
        if(prev == -1 || nums[prev] < nums[i])
        {
            take=1+ func(i+1,i,nums,dp);
        }
        return dp[i][prev+1]= Math.max(take,nottake);

    }
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans=func(0,-1,nums,dp);
        return ans;
    }
}