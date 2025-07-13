class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0;
        int Maxlen=0;
        Set<Character> set= new HashSet<>();
        int l=0,r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            if(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }else{
                set.add(ch);
                Maxlen=Math.max(Maxlen,r-l+1);
                r++;
            }
        }
        return Maxlen;
    }
}