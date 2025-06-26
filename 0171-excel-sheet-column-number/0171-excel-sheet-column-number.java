class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        int pow=columnTitle.length()-1;
        for(char c:columnTitle.toCharArray())
        {
            int val = (int) (c-'A') + 1;
            ans += val * Math.pow(26,pow);
            pow--;
        }
        return ans;


    }
}