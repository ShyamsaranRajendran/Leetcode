class Solution {
    int func(String s)
    {
        int cnt=0;
        for(char c:s.toCharArray())
        {
            if(c=='1')
            {
                cnt++;
            }
        }
        return cnt;
    }
    public int numberOfBeams(String[] bank) {
        List<Integer> lis= new ArrayList<>();
        for( String s:bank)
        {
            int val=func(s);
            if(val!=0)
            {
                lis.add(val);
            }
        }
        if(lis.size()>0)
        {
           int ans=0;
           for(int i=0;i<lis.size()-1;i++)
           {
             ans+=(lis.get(i)*lis.get(i+1));
           }
           return ans;
        }else{
            return 0;
        }
    }
}