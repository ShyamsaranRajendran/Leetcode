class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)-> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int cnt=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            int prevX=points[i][0];
            int prevY=points[i][1];
            int maxY=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                int curX=points[j][0];
                int curY=points[j][1];
                if(prevX<=curX && prevY>=curY && maxY<curY){
                    cnt++;
                    maxY=curY;
                }
            }
        }
        return cnt;

    }
}