class Solution {
    public int maxDifference(String s) {
        int apl[]=new int[26];
        for(char i:s.toCharArray())
        {
            apl[i-'a']++;
        }
        int max=0,min=s.length();
        for(int i=0;i<26;i++)
        {
            if(apl[i]%2==1)
            {
                max=Math.max(apl[i],max);
            }
            else if (apl[i]%2==0 && apl[i]!=0)
            {
                min=Math.min(apl[i],min);
            }
        }
        System.out.println(max + " "+ min);
        return max-min;

    }
}