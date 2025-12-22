class Solution {

    int func(int start, int end,int []cuts,int dp[][]){

        if(start>end) return 0;

        if(dp[start][end] !=-1 ) return dp[start][end]; 

        int mini=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            int cost = cuts[end+1] - cuts[start-1] + func(start,i-1,cuts,dp) + func(i+1,end,cuts,dp);
            mini=Math.min(cost,mini);
        }
        return dp[start][end]=mini;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int newCuts[]=new int[cuts.length+2];
        newCuts[0]=0;
        newCuts[cuts.length+1]=n;

        for(int i=0;i<cuts.length;i++){
            newCuts[i+1]=cuts[i];
        }

        int dp[][]=new int[cuts.length + 2][cuts.length + 2];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }

        int ans=func(1,cuts.length,newCuts,dp);
        return ans;
    }
}