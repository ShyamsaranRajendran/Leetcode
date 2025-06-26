import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int case1 = robRecursive(nums, 0, n - 2, memo1);
        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        int case2 = robRecursive(nums, 1, n - 1, memo2);

        return Math.max(case1, case2);
    }

    private int robRecursive(int[] nums, int current, int end, int[] memo) {
        if (current > end) return 0;

        if (memo[current] != -1) return memo[current];

        int robCurrent = nums[current] + robRecursive(nums, current + 2, end, memo);
        int skipCurrent = robRecursive(nums, current + 1, end, memo);

        memo[current] = Math.max(robCurrent, skipCurrent);
        return memo[current];
    }
}
