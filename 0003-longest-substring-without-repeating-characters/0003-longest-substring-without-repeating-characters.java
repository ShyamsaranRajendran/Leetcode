class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();

        int left=0;
        int maxLen=0;

        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
           if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c,i);
            maxLen = Math.max(maxLen,i-left+1);
        }

        return maxLen;
    }
}