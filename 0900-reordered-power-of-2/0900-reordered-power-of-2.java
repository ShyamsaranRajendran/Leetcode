import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
       String target=Decode(String.valueOf(n));

       Set<String> set= new HashSet<>();

       for(int i=0;i<=31;i++){
        int val= 1 << i;
        String cur=Decode(String.valueOf(val));
        set.add(cur);
       }

       return set.contains(target);
    }

    String Decode(String nums){
        char[]arr=nums.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
