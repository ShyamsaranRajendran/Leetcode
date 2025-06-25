class Solution {
    void func(boolean []visited,int []nums,List<Integer> cur,List<List<Integer>> res)
    {
        if(cur.size()==nums.length)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])) continue;

           
                cur.add(nums[i]);
                visited[i]=true;
                func(visited,nums,cur,res);
                visited[i]=false;
                cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lis=new ArrayList<>();
        Arrays.sort(nums);
        boolean []visited=new boolean[nums.length];
        func(visited,nums,new ArrayList<>(),lis);
        return lis;
    }
}