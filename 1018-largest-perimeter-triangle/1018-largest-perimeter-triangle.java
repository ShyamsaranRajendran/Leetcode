class Solution {
    public int largestPerimeter(int[] nums) {
     Arrays.sort(nums);
     int n=nums.length-1;
     int ans=0;
     for(int i=n;i>1;i--)
     {
        int a=nums[i-2];
        int b=nums[i-1];
        int c=nums[i];
          ans = a+b+c;

           if(a+b > c)
           {
            return ans;
           }
     }   
     return 0;
    }
}
