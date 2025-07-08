class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int ins = 0; 

        for (int i = 0; i < t.length(); i++) {
            if (ins < s.length() && s.charAt(ins) == t.charAt(i)) {
                ins++; 
                if (ins == s.length()) {
                    return true;
                }
            }
        }

        return ins == s.length();
    }
}
