class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        int n=nums.length,cursum=0;
        int cnt=0;
        map.put(0,1);
        for(int i=0;i<n;i++)
        {
            cursum+=nums[i];
            int diff=cursum-k;
            cnt+=map.getOrDefault(diff,0);
            map.put(cursum,map.getOrDefault(cursum,0)+1);
        }
        return cnt;
    }
}