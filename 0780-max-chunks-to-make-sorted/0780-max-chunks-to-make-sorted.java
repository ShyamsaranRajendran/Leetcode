class Solution {
    public int maxChunksToSorted(int[] arr) {
        int par=0,n=arr.length;
        int sum=0,indsum=0;
        for(int i=0;i<n;i++)
        {
            indsum+=i;
            sum+=arr[i];
            if(indsum==sum)
            {
                par++;
            }
        }
        return par;
    }
}