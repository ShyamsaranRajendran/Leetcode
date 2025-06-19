class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();

        for(List<Integer> lis : wall)
        {
            int sum=0;
            for (int i = 0; i < lis.size() - 1; i++) {
                sum += lis.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        }
       int res=0;
       for(int y:map.values())
       {
        res=Math.max(res,y);
       }

        return wall.size() - res;
    }
}