class Solution {

    int func(int i,int []nums,int dp[]){
        if(i>=nums.length){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }

        int take = nums[i] +  func(i+2,nums,dp);
        int notTake = func(i+1,nums,dp);

        return dp[i]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans= func(0,nums,dp);
        return ans;
    }
}