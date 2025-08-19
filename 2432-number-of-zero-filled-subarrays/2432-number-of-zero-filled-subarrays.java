class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long res=0;
        long cont=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                cont++;
                res+=cont;
            }else{
                cont=0;
            }
        }
        return res;
    }
}