class Solution {

    int func(int ind,int prev,int nums[],int dp[][]){
       
       if(ind==nums.length){
        return 0;
       }

       if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];

       int nottake = func(ind+1,prev,nums,dp);
       int take = 0;
       if(prev == -1 || nums[ind] > nums[prev]){
         take = 1 + func(ind+1,ind,nums,dp);
       }

       return dp[ind][prev+1] = Math.max(nottake,take);

    }
    public int lengthOfLIS(int[] nums) {
        int res=0;
        int dp[][] = new int[nums.length][nums.length+1];
        for(int d[]:dp)
           Arrays.fill(d,-1);
        res = func(0,-1,nums,dp);
        return res;
    }
}