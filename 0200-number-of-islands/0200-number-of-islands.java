class Pair {
    int first;
    int second;
    
    Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

class Solution {

    public void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        int n = grid.length;
        int m = grid[0].length;

        // Define row and column movements for 4 directions (up, down, left, right)
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            int a = cell.first;
            int b = cell.second;

            for (int i = 0; i < 4; i++) {
                int newRow = a + dRow[i];
                int newCol = b + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    !vis[newRow][newCol] && grid[newRow][newCol] == '1') {
                    q.add(new Pair(newRow, newCol));
                    vis[newRow][newCol] = true;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }

        return cnt;
    }
}