class Solution {
   public int[] findingUsersActiveMinutes(int[][] logs, int k) {
       int res[]=new int[k];
       HashMap<Integer,HashSet<Integer>> map= new HashMap<>();

       for(int []log:logs)
       {
        int id=log[0];
        int action=log[1];
        if(!map.containsKey(id))
        {
            map.put(id,new HashSet<>());
        }
        map.get(id).add(action);
       }

       for(int i:map.keySet())
       {
        int uam=map.get(i).size();
        res[uam-1]++;
       }
       return res;
    }
}