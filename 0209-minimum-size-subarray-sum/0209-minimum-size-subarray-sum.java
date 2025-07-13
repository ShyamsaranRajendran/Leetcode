class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     int min=(int)1e9;
     int l=0,r=0;
     int sum=0;
     while(r<nums.length)
     {
        sum+=nums[r];
        while(sum>=target)
        {
            min=Math.min(min,(r-l+1));
            sum-=nums[l];
            l++;
        }
        r++;
     }
     return min==(int)1e9?0:min;
    }
}
