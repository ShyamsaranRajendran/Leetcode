class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int mid=0;
        while(low<=high)
        {
             mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(target>nums[mid]){
                 low=mid+1;
            }else{
                 high=mid-1;
            }
        }

        return low;
    }
}