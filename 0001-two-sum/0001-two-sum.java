class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        Arrays.fill(res,-1);
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int co=target-nums[i];
            if(map.containsKey(co)){
                res[0]=map.get(co);
                res[1]=i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}