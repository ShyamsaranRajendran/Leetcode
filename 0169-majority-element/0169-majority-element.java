
class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int cad=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(count==0)
            {
                cad=nums[i];
                count=1;
            }
            else
            count+=(cad==nums[i])?1:-1;
        }
        return cad;
    }
}