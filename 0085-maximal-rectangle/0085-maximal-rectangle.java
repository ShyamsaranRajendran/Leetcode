class Solution {
    public int area(int []heights){
        int n=heights.length;

        int leftArray[]= new int[n];
        int rightArray[]= new int[n];

        Stack<Integer> stk= new Stack<>();

        for(int i=0;i<n;i++){

            while(!stk.isEmpty() && heights[i]<=heights[stk.peek()]){
                stk.pop();
            }

            if(stk.isEmpty()){
                leftArray[i]=0;
            }else{
                leftArray[i]=stk.peek() + 1;
            }

            stk.push(i);
        }

        stk.clear();

        for(int i=n-1;i>=0;i--){

            while(!stk.isEmpty() && heights[i]<=heights[stk.peek()]){
                stk.pop();
            }

            if(stk.isEmpty()){
                rightArray[i]=n-1;
            }else{
                rightArray[i]=stk.peek() - 1;
            }

            stk.push(i);
        }

        int maxArea=0;
        for(int i=0;i<n;i++){
            maxArea=Math.max((rightArray[i] - leftArray[i] + 1)*heights[i] , maxArea);
        }
        return maxArea;
    } 

    public int maximalRectangle(char[][] matrix) {
        int sumArray[]=new int[matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
            if (matrix[i][j] == '1') sumArray[j] += 1;
            else sumArray[j] = 0;

           }
           res=Math.max(area(sumArray),res);
        }

        return res;
    }
}