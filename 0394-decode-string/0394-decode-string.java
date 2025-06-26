class Solution {
    public String decodeString(String s) {
        StringBuilder decodedString = new StringBuilder();

        Stack<Integer> IntegerStack= new Stack<>();
        Stack<StringBuilder> StringStack= new Stack<>();
        int n=0;
        for(Character c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
               n=n*10 + (c-'0');
            }
            else if( c=='[')
            {
                IntegerStack.push(n);
                n=0;
                StringStack.push(decodedString);
                decodedString= new StringBuilder();
            }
            else if( c==']')
            {
                int times=IntegerStack.pop();
                StringBuilder repeatString=decodedString;
                decodedString=StringStack.pop();
                while(times>0)
                {
                    decodedString.append(repeatString);
                    times--;
                }
            }else{
                decodedString.append(c);
            }

        }
        return decodedString.toString();
        
    }
}