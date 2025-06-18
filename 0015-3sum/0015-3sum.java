class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> lis = new ArrayList<>();
       int n=nums.length;
       Arrays.sort(nums);
       for(int i=0;i<n;i++)
       {
          if(i>0 && nums[i]==nums[i-1]) continue;

          int l=i+1;
          int r=nums.length-1;
          while(l<r)
          {
            int val=nums[i]+nums[l]+nums[r];
            if(val==0)
            {
                List<Integer> t=new ArrayList<>();
                t.add(nums[i]);
                t.add(nums[l]);
                t.add(nums[r]);
                Collections.sort(t);
                lis.add(t);
                l++;
                r--;
                while( l < r && nums[l]==nums[l-1]) l++;
                while(r>l && nums[r]==nums[r+1]) r--;
            
            }else if(val > 0){
              r--;
            }else{
                l++;
            }
          }
       }
       return lis;
    }
}