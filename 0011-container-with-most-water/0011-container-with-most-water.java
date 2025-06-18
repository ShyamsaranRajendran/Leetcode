class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int maxArea=Integer.MIN_VALUE;

        while(l<r)
        {
            int area=(r-l)*(Math.min(height[l],height[r]));
            maxArea=Math.max(maxArea,area);
            if(height[l]>height[r])
            {
                r--;
             
            }else{
                l++;
            }

            
        }
        return maxArea;

    }
}