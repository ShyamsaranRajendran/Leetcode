class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s2= new StringBuilder();
        int n=s.length();
        for (int i = n - 1; i >= 0; i--) {
         s2.append(s.charAt(i));
        }
        String rev=s2.toString();

        int dp[][]=new int[n+1][n+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==rev.charAt(j-1))
                {
                    dp[i][j]= 1 + dp[i-1][j-1];
                }else{
                    dp[i][j]= 0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder palin=new StringBuilder();
        // for(int i=0;i<=n;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //     {
        //        System.out.print(dp[i][j]+"\t");
        //     }
        //     System.out.println();
        // }
        int i=n,j=n;
        while(i>0 && j>0)
        {
            if(s.charAt(i-1)==rev.charAt(j-1))
            {
               palin.append(s.charAt(i-1));
               i--;
               j--;
            }else{
                int up=(i>0)?dp[i-1][j]:0;
                int left=(j>0)?dp[i][j-1]:0;
                if(up>=left)
                {
                    i--;
                }else{
                    j--;
                }
            }
        }
        System.out.println(palin.reverse().toString());
        return dp[n][n];
    }
}