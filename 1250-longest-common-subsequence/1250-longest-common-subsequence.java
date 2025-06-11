class Solution {

    int func(int ind1,int ind2,String t1,String t2,int dp[][]){
        if(ind1<0 ||ind2<0)
        {
            return 0;
        }
        if(dp[ind1][ind2]!=-1)
           return dp[ind1][ind2];

        if(t1.charAt(ind1)==t2.charAt(ind2))
        {
            return dp[ind1][ind2] = 1 + func(ind1-1,ind2-1,t1,t2,dp);
        }else{
            int l=func(ind1-1,ind2,t1,t2,dp);
            int r=func(ind1,ind2-1,t1,t2,dp);
            return dp[ind1][ind2]=Math.max(l,r);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int dp[][]=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int ans=func(text1.length()-1,text2.length()-1,text1,text2,dp);
        return ans;
    }
}