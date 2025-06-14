class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, n, new boolean[n], new boolean[n+n], new boolean[n+n]);
    }

    private int backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            return 1;
        }
        int total = 0;
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row+col] || diag2[row - col + n-1]) continue;
            cols[col] = diag1[row+col] = diag2[row - col + n -1] = true;
            total += backtrack(row+1, n, cols, diag1, diag2);
            cols[col] = diag1[row+col] = diag2[row - col + n -1] = false;
        }
        return total;
    }
}