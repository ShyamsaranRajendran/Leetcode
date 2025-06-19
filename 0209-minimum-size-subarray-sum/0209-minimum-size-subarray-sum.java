class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=(int)1e9;
        int sum=0;
        int l=0;

        for(int r=0;r<nums.length;r++)
        {
            sum+=nums[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        

        return min!=(int)1e9?min:0;
    }
}