class Solution {
    
    public int maximumDifference(int[] nums) {
        
        int n=nums.length;
        int min=nums[0];
        int diff=-1;
        for(int i=1;i<n;i++)
        {
            min=Math.min(min,nums[i]);
            diff=Math.max(diff,nums[i]-min);
        }

        return (diff<=0)?-1:diff;
    }
}