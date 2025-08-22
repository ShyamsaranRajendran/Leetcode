class Solution {
    boolean func(int i,int nums[],int cur,int sum,Boolean dp[][]){
        if(i>=nums.length || cur > sum){
            return false;
        }
        if(cur==sum){
            return true;
        }
        if(dp[i][cur]!=null){
            return dp[i][cur];
        }
        Boolean pick = func(i+1,nums,cur+nums[i],sum,dp);
        Boolean notpick = func(i+1,nums,cur,sum,dp);

        return dp[i][cur]= pick || notpick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2!=0) return false;
        int target=sum/2;
        Boolean dp[][]=new Boolean[nums.length +1][target+1];
        boolean res=func(0,nums,0,target,dp);
        return res;
    }
}