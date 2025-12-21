import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stk = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') continue;

            if (ch != ')') {
                stk.push(ch);
            } else {
                // Evaluate inside ()
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (stk.peek() != '(') {
                    char val = stk.pop();
                    if (val == 't') hasTrue = true;
                    if (val == 'f') hasFalse = true;
                }

                stk.pop(); // remove '('
                char op = stk.pop(); // operator

                char result;
                if (op == '!') {
                    result = hasTrue ? 'f' : 't';
                } else if (op == '&') {
                    result = hasFalse ? 'f' : 't';
                } else { // '|'
                    result = hasTrue ? 't' : 'f';
                }

                stk.push(result);
            }
        }

        return stk.pop() == 't';
    }
}
