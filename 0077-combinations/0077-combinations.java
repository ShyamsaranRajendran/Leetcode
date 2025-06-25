class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> list= new ArrayList<>();
      backtrack(1,n,k,new ArrayList<>(),list);
      return list;
    }

    void backtrack(int num,int n,int k ,List<Integer>  cur,List<List<Integer>> res)
    {
        if(k==cur.size()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=num;i<=n;i++)
        {
            cur.add(i);
            backtrack(i+1,n,k,cur,res);
            cur.remove(cur.size()-1);
        }
    }

}