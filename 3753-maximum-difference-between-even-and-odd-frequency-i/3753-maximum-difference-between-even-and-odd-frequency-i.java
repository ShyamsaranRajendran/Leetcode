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
                if(apl[i]>max)
                 max=apl[i];
            }
            else if (apl[i]%2==0 && apl[i]!=0)
            {
                if(apl[i]<min)
                min=apl[i];
            }
        }
        System.out.println(max + " "+ min);
        return max-min;

    }
}