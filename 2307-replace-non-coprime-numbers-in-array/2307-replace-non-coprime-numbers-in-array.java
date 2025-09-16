class Solution {
    int gcd(int a,int b){
       return b==0 ? a : gcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
      List<Integer> stk  = new ArrayList<>();
      for(int num:nums){
        stk.add(num);

        while(stk.size()>1){
            int num1=stk.get(stk.size()-1);
            int num2=stk.get(stk.size()-2);
            int g=gcd(num1,num2);
            if(g==1) 
               break;
            int lcm= num1 / g * num2;
            stk.remove(stk.size()-1);
            stk.remove(stk.size()-1);
            stk.add((int)lcm);
        }
      }  
      return stk;
    }
}