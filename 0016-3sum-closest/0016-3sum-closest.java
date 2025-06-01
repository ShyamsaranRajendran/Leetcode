
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);int n=nums.length;
        int closestsum=nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<n-2;i++){
            int start=i+1;
            int end=n-1;
            while(start<end){
                int currsum=nums[i]+nums[start]+nums[end];
                if(currsum>target){
                    end--;
                }
                else{
                    start++;
                }
                if(Math.abs(currsum-target)<Math.abs(closestsum-target)){
                    closestsum=currsum;
            }
                
        }
    }
        return closestsum;
    }
    
}