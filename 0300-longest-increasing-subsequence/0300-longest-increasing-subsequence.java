class Solution {

    int func(int ind,int prev,int[]nums,int dp[][]){
        if(ind==nums.length) return 0;

        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];

        int nottake =  func(ind+1,prev,nums,dp);
        int take=0;

        if(prev==-1 || nums[ind] > nums[prev])
            take = 1 + func(ind+1,ind,nums,dp);

          return dp[ind][prev+1]=Math.max(nottake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int nt=dp[i+1][j+1];
                int t=0;
                if(j==-1 || nums[i] > nums[j])
                 t = 1 + dp[i+1][i+1];

                dp[i][j+1] = Math.max(nt,t);
            }
        }
        return dp[0][0];
    }
}