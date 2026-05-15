class Solution {
    public int findMin(int[] nums) {
        int ans=(int)1e9;
        int low = 0 ;
        int high =nums.length-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            
            if(nums[low]<=nums[high]){
                ans=Math.min(nums[low],ans);
                break;
            }

            if(nums[low] <= nums[mid]){
                ans=Math.min(nums[low],ans);
                low=mid+1;
            }else{
                ans=Math.min(nums[mid],ans);
                high=mid-1;
            }
        }
        return ans;
    }
}