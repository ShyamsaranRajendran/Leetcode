class Solution {
    public int maxChunksToSorted(int[] arr) {
        // int par=0,n=arr.length;
        // int sum=0,indsum=0;
        // for(int i=0;i<n;i++)
        // {
        //     indsum+=i;
        //     sum+=arr[i];
        //     if(indsum==sum)
        //     {
        //         par++;
        //     }
        // }

        int chunks=0;
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
            if(max==i)
            {
                chunks++;
            }
        }
        return chunks;
    }
}