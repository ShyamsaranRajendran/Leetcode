class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum=0;
        long sum=0, n=nums.length;
        HashSet<Integer> set= new HashSet<>();
        int l=0,r=0;
        while(r<n)
        {
            while(set.contains(nums[r]))
            {
                set.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
             set.add(nums[r]);
            sum+=nums[r];
            if((r-l+1)>k)
            {
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
            if((r-l+1)==k)
                maxSum=Math.max(sum,maxSum);
            r++;
            
        }
        return maxSum;
    }
}