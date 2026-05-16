class Solution {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // duplicates
            if (nums[mid] == nums[high]) {
                high--;
            }

            // minimum on right side
            else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }

            // minimum on left side including mid
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}