class Solution {
    public int firstUniqChar(String s) {
        int[]a=new int[26];
        for(char i:s.toCharArray()){
            a[i-'a']++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(a[s.charAt(i)-'a']==1)
            {
                return i;
            }
        }
        return -1;
    }
}