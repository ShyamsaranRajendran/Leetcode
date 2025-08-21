class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }

            for (int j = 0; j < n; j++) {
                int minHeight = heights[j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, heights[k]);
                    res += minHeight;
                }
            }
        }

        return res;
    }
}
