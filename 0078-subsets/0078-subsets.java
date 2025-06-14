class Solution {
    void func(int i,int[]nums,List<Integer> cur,List<List<Integer>> res)
    {
        if(i>=nums.length)
        {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        func(i+1,nums,cur,res);
        cur.remove(cur.size()-1);
        func(i+1,nums,cur,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        func(0,nums,new ArrayList<>(),list);
        return list;
    }
}