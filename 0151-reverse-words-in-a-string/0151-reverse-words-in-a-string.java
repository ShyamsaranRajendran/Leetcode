class Solution {
    public String reverseWords(String s) {
        String word[]= s.trim().split("\\s+");
        int l=word.length;

        for(int i=0;i<l/2;i++)
        {
            String t=word[i].trim();
            word[i]=word[l-i-1].trim();
            word[l-i-1]=t.trim();
        }
        return String.join(" ", word);
        }
}