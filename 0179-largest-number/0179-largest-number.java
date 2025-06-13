class Solution {
    public String largestNumber(int[] nums) {
        
        String[]newnums=new String[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            newnums[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(newnums, (a,b)->(b+a).compareTo(a+b));
        if(newnums[0].equals("0"))
        {
            return "0";
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            s.append(newnums[i]);
        }
        return s.toString();


    }
}