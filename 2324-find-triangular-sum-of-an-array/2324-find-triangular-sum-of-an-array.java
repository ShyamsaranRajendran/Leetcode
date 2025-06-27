class Solution {
    public int triangularSum(int[] nums) {
       List<Integer> list= new ArrayList<>();
       List<Integer> res= new ArrayList<>();
       for(int i:nums) res.add(i);
       int n=nums.length;
       int m=n;
       while(m>0 && res.size()!=1){

           for(int i=1;i<res.size();i++)
           {
             int val= res.get(i-1)+ res.get(i);
             list.add(val%10);
            }
            res=list;
            list=new ArrayList<>();
            m--;
       }
       return res.get(0);
      
    }
}