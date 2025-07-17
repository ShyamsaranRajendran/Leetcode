class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stk=new Stack<>();

        for(char c: num.toCharArray()){

            while(!stk.isEmpty() && k > 0 && stk.peek()>c) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }

        while(k>0){
            stk.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char digit : stk) {
            result.append(digit);
        }

        while(result.length()>0 && result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }

         while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

       
        return result.length() == 0 ? "0" : result.toString();

    }
}