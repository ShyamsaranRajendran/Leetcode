class Solution {
    public int smallestNumber(int n) {
        String str= new String();
        while(n!=0)
            {
                str+=(n%2);
                n/=2;
            }
        int res=0;
        for(int i=0;i<str.length();i++)
            {
                res+=Math.pow(2,i);
            }
        return res;
    }
}