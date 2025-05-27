class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int cursum=maxsum;
        for(int i=1;i<nums.length;i++)
        {
            cursum=Math.max(cursum + nums[i], nums[i]);
            maxsum=Math.max(maxsum,cursum);
        }
        return maxsum;
    }
}