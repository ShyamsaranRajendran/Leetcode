class Solution {
    boolean possible(int arr[],int min,int k,int m)
    {
        int cnt=0;
        int days=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=min)
            {
                cnt++;
            }else{
                days+=(cnt/k);
                if(m<=days)
                {
                    return true;
                }
                cnt=0;
            }
        }
        days+=(cnt/k);

        return m<=days;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(k*m > bloomDay.length )
        {
            return -1;
        }

        int min=bloomDay[0];
        int max=min;

        for(int i:bloomDay)
        {
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        int l=min,r=max,ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(possible(bloomDay,mid,k,m))
            {
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}