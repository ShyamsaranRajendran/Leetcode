class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=(int)1e9;
        for(int i=0;i+k-1 < nums.length;i++){
            int diff = nums[i+k-1] - nums[i];
            ans=Math.min(diff,ans);
        }
        return ans;
    }
}