class Solution {
    boolean func(int i,int j,String s,String p,int[][]dp)
    {
        boolean result=false;
        if(i<0 && j<0 )
        {
            return true;
        }
        
      if(i>=0 && j<0 ) return false;
        
         if(i<0 && j>=0 ) {
            for(int k=j;k>=0;k--)
               if(p.charAt(k)!='*') return false;
            return true;
         }

         if (dp[i][j] != -1) return dp[i][j] == 1;

        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?')
           result= func(i-1,j-1,s,p,dp);
        else if(p.charAt(j)=='*'){
           boolean t1= func(i,j-1,s,p,dp);
           boolean t2= func(i-1,j,s,p,dp);
            result= t1 || t2;
        }
        else
         result=false;
        dp[i][j]=result?1:0;
        return result; 

    }
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        int dp[][]= new int[n][m];

        for(int i=0;i<n;i++)
          Arrays.fill(dp[i],-1);
        
        return func(n-1,m-1,s,p,dp);
    }
}