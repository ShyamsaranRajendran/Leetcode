class Solution {

    int func(int ind,int arr[],int k,int dp[]){

        if(ind==arr.length) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int sum=0, maxi=0, MaxAns=0, len=0;

        for(int j=ind;j<Math.min(ind+k,arr.length);j++){
            len++;
            maxi= Math.max(maxi,arr[j]);
            sum = maxi*len + func(j+1,arr,k,dp);
            MaxAns = Math.max(MaxAns,sum);
        }

        return dp[ind]=MaxAns;

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int ans;
        int dp[]=new int[arr.length];
        Arrays.fill(dp,-1);
        ans=func(0,arr,k,dp);
        return ans;
    }
}