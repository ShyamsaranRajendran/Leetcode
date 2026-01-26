class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> list = new ArrayList<>(); 
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<A.length;i++){
            minDiff = Math.min(minDiff,A[i]-A[i-1]);
        }

        for(int i=1;i<A.length;i++){
            if(minDiff == A[i] - A[i-1]){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(A[i-1]);
                temp.add(A[i]);
                list.add(temp);
            }
        }

        return list;
    }
}
