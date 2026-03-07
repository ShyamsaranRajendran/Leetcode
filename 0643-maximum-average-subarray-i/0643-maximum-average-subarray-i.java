class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res=Double.NEGATIVE_INFINITY;;
        double sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=(k-1)){
               res=Math.max(sum,res);
               sum-=nums[i-k+1];
            }
        }
        res=res/k;
        return res;
    }
}