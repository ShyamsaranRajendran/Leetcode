class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      
        List<Integer> res=new ArrayList<>();
         
         int currcol=0;
         int currrow=0;
         int row=matrix.length-1;
         int col=matrix[0].length-1;

         while( currcol<=col && currrow<=row)
         {
            for(int i=currcol;i<=col;i++)
            {
                res.add(matrix[currrow][i]);
            }
            currrow++;

            for(int i=currrow;i<=row;i++)
            {
                res.add(matrix[i][col]);
            }
            col--;

if(currrow <= row)
{
for(int i=col;i>=currcol;i--)
            {
                res.add(matrix[row][i]);
            }
            row--;
}
            
if(currcol<=col)
{

            for(int i=row;i>=currrow;i--)
            {
                res.add(matrix[i][currcol]);
            }
            currcol++;
}
         }

        return res;
    }
}