class Solution {
    public int maxDifference(String s) {
        int apl[]=new int[26];
        for(char i:s.toCharArray())
        {
            apl[i-'a']++;
        }
        int max=0,min=s.length();
        for(int i:apl)
        {
            if(i%2==1)
            {
                max=Math.max(i,max);
            }
            else
            {
                min=Math.min(i==0?s.length():i,min);
            }
        }
        return max-min;

    }
}