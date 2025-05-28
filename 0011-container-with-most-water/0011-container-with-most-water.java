class Solution {
    public int maxArea(int[] height) {
        int r=height.length-1,l=0,maxArea=0;
        while(l<r)
        {
            maxArea=Math.max(maxArea , Math.min(height[l],height[r]) * (r-l));
            if(height[l] < height[r])
            {
                l++;
            }else {
                r--;
            }
        }
        return maxArea;
    }
}