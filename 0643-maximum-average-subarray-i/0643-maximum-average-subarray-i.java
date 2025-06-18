class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0,n=nums.length;
        int maxSum=Integer.MIN_VALUE,l=0;

        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(i-l+1 > k)
            {
                sum-=nums[l];
                l++;
            }
            if(i-l+1 == k)
            {
                maxSum=Math.max(maxSum,sum);
            }
        }
         return (double) maxSum / k;
    }
}