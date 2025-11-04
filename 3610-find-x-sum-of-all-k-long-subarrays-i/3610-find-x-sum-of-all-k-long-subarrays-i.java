class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int list[]=new int[n-k+1];

        for(int i=0;i<=n-k;i++)
        {
            Map<Integer, Integer> map= new HashMap<>();
            for(int j=0;j<k;j++)
            {
                map.put(nums[i+j], map.getOrDefault(nums[i+j],0) +1);
            }

            List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(map.entrySet());
            entries.sort((a,b)->{
                if(a.getValue()==b.getValue())
                {
                    return b.getKey() - a.getKey();
                }
                else{
                    return b.getValue() - a.getValue();

                }
            });

            for(int j=0;j<Math.min(x,entries.size());j++)
            {
                Map.Entry<Integer,Integer> entry=entries.get(j);
                list[i]+= entry.getValue()*entry.getKey();
            }
        }

        return list;
    }
}