class Solution {
    public boolean possible(int arr[],int days,int m ,int k)
    {   
        System.out.println(days);

        int cnt=0;
        int poss=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=days)
            {
                cnt++;
            }else{
                poss+=(cnt/k);
                cnt=0;
            }
        }
        poss+=(cnt/k);
        System.out.println("bloom : "+ poss);
        return poss>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
       if(k*m > bloomDay.length)
       {
          return -1;
       }
       
       int min=bloomDay[0];
       int max=min;
       for(int i=0;i<bloomDay.length;i++)
       {
        min=Math.min(min,bloomDay[i]);
        max=Math.max(max,bloomDay[i]);
       }

       int days=-1;
       int l=min,r=max;
       while(l<=r)
       {
        int mid=l+(r-l)/2;
        if(possible(bloomDay,mid,m,k))
        {
            days=mid;
            r=mid-1;
        }else{
            l=mid+1;
        }
       }
    
       return days;
    }
}