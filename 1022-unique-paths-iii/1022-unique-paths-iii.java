class Solution {
    int answer = 0;
    int totalSteps = 0;

    public void func(int i, int j, int[][] grid, boolean[][] vis, int steps) {
        int n = grid.length, m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == -1) return;

        if (grid[i][j] == 2) {
            if (steps == totalSteps) answer++;
            return;
        }

        vis[i][j] = true;

        int[] newR = {0, -1, 1, 0};
        int[] newC = {-1, 0, 0, 1};

        for (int p = 0; p < 4; p++) {
            int newI = i + newR[p];
            int newJ = j + newC[p];
            func(newI, newJ, grid, vis, steps + 1);
        }

        vis[i][j] = false; 
    }

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int startI = 0, startJ = 0;
        totalSteps = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != -1) totalSteps++;
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        func(startI, startJ, grid, vis, 1);
        return answer;
    }
}
