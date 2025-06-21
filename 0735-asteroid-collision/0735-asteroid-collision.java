class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for (int i : asteroids) {
            boolean destroyed = false;

            while (!stk.isEmpty() && i < 0 && stk.peek() > 0) {
                if (Math.abs(i) > stk.peek()) {
                    stk.pop();
                } else if (Math.abs(i) == stk.peek()) {
                    stk.pop(); 
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stk.push(i);
            }
        }

        int[] res = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            res[i] = stk.pop();
        }

        return res;
    }
}
