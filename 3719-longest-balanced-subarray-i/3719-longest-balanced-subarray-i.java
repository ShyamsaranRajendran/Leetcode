class Solution {
    public int longestBalanced(int[] nums) {
       
        int max=0;

        for(int i=0;i<nums.length;i++){
             Set<Integer> setEven = new HashSet<>();
             Set<Integer> setOdd = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                    setEven.add(nums[j]);
                }else{
                    setOdd.add(nums[j]);
                }
                
                if(setEven.size()==setOdd.size())
                    max = Math.max(max,j-i+1);
            }
        }

        return max;
    }
}