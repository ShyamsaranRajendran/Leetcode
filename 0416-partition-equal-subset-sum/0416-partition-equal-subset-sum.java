class Solution {

    boolean func(int i , int[]nums,int cur ,int sum,Boolean dp[][])
    {
        if(cur == sum)
        {
            return true;
        }
        if(cur > sum || i>=nums.length)
        {
            return false;
        }
        if(dp[i][cur]!= null) return dp[i][cur];
        boolean pick = func(i+1,nums,cur+nums[i],sum,dp);
        boolean notpick= func(i+1,nums,cur,sum,dp);

        return dp[i][cur] = pick||notpick;
    }
    public boolean canPartition(int[] nums) {
       int sum=0;
       for(int i :  nums) sum+=i;
      
       if(sum%2==1) return false;
       sum=sum/2;
       Boolean dp[][]=new Boolean[nums.length][sum];
       boolean res=  func(0,nums,0,sum,dp);
       return res;
    }
}