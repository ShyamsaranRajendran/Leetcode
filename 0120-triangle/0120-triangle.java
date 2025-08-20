import java.util.List;

class Solution {

    int func(int i,int j,List<List<Integer>> triangle,int dp[][])
    {
        if(i==triangle.size()-1)
        {
            return triangle.get(i).get(j);
        }

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        int up=(int)1e9;
        int dig=(int)1e9;
        up = triangle.get(i).get(j) + func(i+1,j,triangle,dp);
        dig = triangle.get(i).get(j) + func(i+1,j+1,triangle,dp);
        return dp[i][j]=Math.min(up,dig);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
       int n=triangle.size();
       int dp[][]=new int[n][n];
       for(int i=0;i<n;i++)
         Arrays.fill(dp[i],-1);
       return func(0,0,triangle,dp);

    }
}