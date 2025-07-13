class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxFruits=0;
        int left=0;
        for(int i=0;i<fruits.length;i++)
        {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0)+1);
            if(map.size()<=2)
            {
                maxFruits=Math.max(maxFruits, i-left+1);
            }
            while(map.size()>2)
            {
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left])==0)
                {
                    map.remove(fruits[left]);
                }
                left++;
            }
        }
        return maxFruits;
    }
}