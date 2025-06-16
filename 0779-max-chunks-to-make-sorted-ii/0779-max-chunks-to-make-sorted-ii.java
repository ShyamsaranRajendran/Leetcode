class Solution {
    public int maxChunksToSorted(int[] arr) {
        int []newArr=new int[arr.length];
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            newArr[i]=arr[i];
        }
        Arrays.sort(newArr);
        int newSum=0;
        int sum=0;
        int chunk=0;
        for(int i=0;i<n;i++)
        {
            newSum+=newArr[i];
            sum+=arr[i];
            if(newSum==sum)
            {
                chunk++;
            }
        }
        return chunk;

    }
}