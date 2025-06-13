class Solution {
    public String largestNumber(int[] nums) {
        
      String[] number=new String[nums.length];
      for(int i=0;i<nums.length;i++)
      {
        number[i]=String.valueOf(nums[i]);
      }
      Arrays.sort(number,(a,b)->(b+a).compareTo(a+b));
      if(number[0].equals("0"))
      {
        return "0";
      }else{
        StringBuilder str=new StringBuilder();
        for(String i:number)
        {
            str.append(i);
        }
        return str.toString();
      }


    }
}
