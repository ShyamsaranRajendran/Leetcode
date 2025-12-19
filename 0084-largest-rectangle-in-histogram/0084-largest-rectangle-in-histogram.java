class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int leftArray[]=new int[n];
        int rightArray[]=new int[n];

        Stack<Integer> stk= new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                leftArray[i] = 0;
            } else {
                leftArray[i] = stk.peek() + 1;
            }

            stk.push(i);
        }
        
        stk.clear();

        for(int i=n-1;i>=0;i--){
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                rightArray[i] = n - 1;
            } else {
                rightArray[i] = stk.peek() - 1;
            }

            stk.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max((rightArray[i]-leftArray[i]+1)*heights[i],maxArea);
        }

        return maxArea;

    }
}