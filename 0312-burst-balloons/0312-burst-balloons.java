class Solution {

    int func(int start , int end, int nums[],int dp[][]){
      
      if(start>end) return 0;

      if(dp[start][end]!=-1) return dp[start][end];

      int max=0;
      for(int i=start;i<=end;i++){
          int coins = nums[start-1]*nums[i]*nums[end+1] + func(start,i-1,nums,dp) + func(i+1,end,nums,dp);
          max=Math.max(coins,max);
      }
      return dp[start][end]=max;
    }
    public int maxCoins(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        int ans,newnums[]=new int[nums.length + 2];
        newnums[0]=1;
        newnums[nums.length+1]=1;
        for(int i=0;i<nums.length;i++){
            newnums[i+1]=nums[i];
        }
        ans= func(1,nums.length,newnums,dp);
        return ans;
    }
}