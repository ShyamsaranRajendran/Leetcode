class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,max=0;;
        HashSet<Character> set= new HashSet<>();
        while(r<s.length())
        {
            char c=s.charAt(r);
            if(set.contains(c))
            {
               set.remove(s.charAt(l));
               l++;
            }else{
                set.add(s.charAt(r));
                max=Math.max(max,r-l+1);
                r++;
            }
        }
        return max;
    }
}