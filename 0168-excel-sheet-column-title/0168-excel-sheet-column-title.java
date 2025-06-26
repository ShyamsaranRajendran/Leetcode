class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(columnNumber > 0)
        {
           columnNumber--;
           char a= (char)('A'+ columnNumber%26);
           ans.append(a);
           columnNumber/=26;
        }
        return ans.reverse().toString();
    }
}