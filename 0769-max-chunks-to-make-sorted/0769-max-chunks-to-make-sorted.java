class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar=0;
        int chunks=0;

        int n=arr.length;
        for(int i=0;i<n;i++){
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }
        return chunks;
    }
}