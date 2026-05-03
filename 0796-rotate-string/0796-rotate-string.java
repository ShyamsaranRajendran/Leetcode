class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length()!=goal.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            StringBuilder temp = new StringBuilder(s.substring(i,s.length()) + new StringBuilder(s.substring(0,i)) );
            if(goal.equals(temp.toString())){
                return true;
            }
        }

        return false;
    }
}