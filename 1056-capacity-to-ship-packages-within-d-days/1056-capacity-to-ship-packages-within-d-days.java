class Solution {
    int GetMax(int[]weights)
    {
        int max=weights[0];
        for(int i:weights)
            max=Math.max(max,i);
        return max;
    }

    int GetSum(int weights[])
    {
        int sum=0;
        for(int i:weights)
            sum+=i;
        return sum;
    }
    boolean Shipping(int[]weights,int days,int cap)
    {
        int cur=0,d=1;
        for(int i:weights)
         {
            if(i>cap) return false;
            if (cur + i > cap) {
            d++;
            cur = 0;
            }
        cur += i;
         }
          return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left=GetMax(weights);
        int right=GetSum(weights);
        int sum=0,result=0;
        while(left <= right)
        {
            int capacity = (left + right) / 2;

            if(Shipping(weights,days,capacity))
            {
                result = capacity;
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }
        return result;
    }
}