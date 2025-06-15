class Solution {
    int func(int i,int j,String s,String t,int dp[][])
    {
        if(i==0) 
        return j;
        if(j==0)
        return i;
        if(dp[i][j]!=-1)
          return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1))
        {
            return dp[i][j]= 0 + func(i-1,j-1,s,t,dp);
        }else{
            int d= 1 + func(i-1,j,s,t,dp);
            int ins= 1+ func(i,j-1,s,t,dp);
            int  rep = 1+ func(i-1,j-1,s,t,dp);

            return dp[i][j]= Math.min(d,Math.min(ins,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=n;i++)
          Arrays.fill(dp[i],-1);
        int res=func(n,m,word1,word2,dp);
        return res;
    }
}