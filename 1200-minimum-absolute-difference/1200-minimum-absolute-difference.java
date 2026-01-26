class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] A) {
        Arrays.sort(A);

        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];

            if (diff < minDiff) {
                minDiff = diff;
                result.clear(); 
                result.add(Arrays.asList(A[i - 1], A[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(A[i - 1], A[i]));
            }
        }

        return result;
    }
}