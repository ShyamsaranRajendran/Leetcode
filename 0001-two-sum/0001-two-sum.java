class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]= new int[2];
        Arrays.fill(res,-1);
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
           if(map.containsKey(nums[i]))
           {
            res[0]=map.get(nums[i]);
            res[1]=i;
            return res;
           }
           map.put(target-nums[i],i);
        }
        return res;
    }
}