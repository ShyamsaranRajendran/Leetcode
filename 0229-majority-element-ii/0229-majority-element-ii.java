class Solution {
    void func(int[]nums,List<Integer> res)
    {
        int count=1;
        int cad=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(cad==nums[i])
            {
               count++;
            }else{
                if(count > (nums.length/3))
                {
                    res.add(cad);
                }
                cad=nums[i];
                count=1;
            }
        }

         if (count > nums.length / 3) {
            res.add(cad);
        }
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list= new ArrayList<>();
        Arrays.sort(nums);
        func(nums,list);
        return list;
    }
}