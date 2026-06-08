class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i=0;
        int j=nums.length-1;
        int ans[]=new int[nums.length];
        int i1=0;
        int j1=nums.length-1;
        while(i<nums.length&&j>=0){
            if(nums[i]<pivot){
                ans[i1++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[j1--]=nums[j];
            }
            i++;
            j--;
        }
        for(int k=i1;k<=j1;k++){
            ans[k]=pivot;
        }
        return ans;
    }
}