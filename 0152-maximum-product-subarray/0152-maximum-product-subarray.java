class Solution {
    public int maxProduct(int[] nums) {
       
        int n=nums.length;
        int maxprod=(int)-1e9;
        for(int i=0;i<n;i++)
        {
            int prod=nums[i];
            maxprod=Math.max(prod,maxprod);
            for(int j=i+1;j<n;j++)
            {
                prod*=nums[j];
                maxprod=Math.max(prod,maxprod);
            }
           
        }
        return maxprod;
        
    }
}