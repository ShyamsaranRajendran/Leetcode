class Solution {
    public int triangularSum(int[] nums) {
      
       int end=nums.length;
       while(end>=1){

           for(int i=0;i<end-1;i++)
           {
             nums[i]=(nums[i+1]+nums[i])%10;
           }
           end=end-1;
       }
       return nums[0];
      
    }
}