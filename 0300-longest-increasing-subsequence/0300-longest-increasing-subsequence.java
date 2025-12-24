class Solution {

    int func(int ind,int prev,int []nums){
        if(nums.length==ind) return 0;

        int nottake = func(ind+1,prev,nums);

        int take=0;
        if(prev==-1 || nums[prev] < nums[ind] ){
             take = 1 + func(ind+1,ind,nums);
        }

        return Math.max(nottake,take);
    }
    public int lengthOfLIS(int[] nums) {
    //    int res = func(0,-1,nums);
       int n=nums.length;
       int dp[][]=new int[n+1][n+2];

       for(int i=n-1 ;i>=0;i--){
        for(int prev=i-1;prev>=-1;prev--){
             int nt = dp[i+1][prev+1];
             int t=0;
             if(prev==-1 || nums[i] > nums[prev]){
                t= 1 + dp[i+1][i+1];
             }
             dp[i][prev+1]= Math.max(nt,t);
        }
       }
       return dp[0][0]; 
    }
}