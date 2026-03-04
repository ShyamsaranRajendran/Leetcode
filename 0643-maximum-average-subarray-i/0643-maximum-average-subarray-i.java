class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;
        double sum = 0;
        int n = k - 1;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(i >= n) {
                res = Math.max(res, sum);
                sum -= nums[i - n];
            }
        }
        return res / k;
    }
}