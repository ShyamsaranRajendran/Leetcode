class Solution {
    public String largestGoodInteger(String num) {
        String res=new String();
        for(int i=0;i<num.length()-2;i++)
        {
          String val = num.substring(i, i + 3);
          if (val.charAt(0) == val.charAt(1) && val.charAt(1) == val.charAt(2)) {
               if(val.compareTo(res) > 0)
               {
                res=val;
               }
            }
        }

        return res;
    }
}