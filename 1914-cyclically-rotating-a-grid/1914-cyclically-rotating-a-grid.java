class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n=grid[0].length;

        int layers = Math.min(m,n) / 2;

        for(int layer=0;layer<layers;layer++){

            int top=layer;
            int left = layer;
            int bottom= m-layer-1;
            int right= n-layer-1;
            
            List<Integer> temp = new ArrayList<>();
            
            // top row
            for(int j = left ;j <=right ;j++){
                temp.add(grid[top][j]);
            }
            
            // right column
            for(int i = top+1 ;i <= bottom-1 ;i++){
                 temp.add(grid[i][right]);
            }

            // bottom row
            for(int j = right;j>= left ;j--){
                temp.add(grid[bottom][j]);
            }

            //left column
            for(int i=bottom-1 ;i>=top+1;i--){
                temp.add(grid[i][left]);
            }
            
            List<Integer> rotated = new ArrayList<>();
            int len=temp.size();
            int rotate = k % len;
            for(int i=0;i<len;i++){
                rotated.add(temp.get((i+rotate)%len));
            }
            
            int idx=0;

            // top row
            for(int j = left ;j <=right ;j++){
                grid[top][j]=rotated.get(idx++);
            }
            
            // right column
            for(int i = top+1 ;i <= bottom-1 ;i++){
                grid[i][right]=rotated.get(idx++);
            }

            // bottom row
            for(int j = right;j>= left ;j--){
                grid[bottom][j]=rotated.get(idx++);
            }

            //left column
            for(int i=bottom-1 ;i>=top+1;i--){
               grid[i][left]=rotated.get(idx++);
            }
        }

        return grid;
    }
}