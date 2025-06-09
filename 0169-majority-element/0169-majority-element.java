class Solution {
    public int majorityElement(int[] nums) {
        int cad=nums[0];
        int count=1;

        for(int i=1;i<nums.length;i++)
        {
           if(count==0)
           {
            cad=nums[i];
            count=1;
           }else{
            count+= (cad==nums[i]?1:-1);
           }
        }
        return cad;
    }
}