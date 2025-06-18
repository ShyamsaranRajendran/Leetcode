class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2]; 

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;

            while (l < r) {
                int val = nums[i] + nums[l] + nums[r];

                if (val == target) return val; 

                if (Math.abs(target - val) < Math.abs(target - ans)) {
                    ans = val;
                }

                if (val < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
