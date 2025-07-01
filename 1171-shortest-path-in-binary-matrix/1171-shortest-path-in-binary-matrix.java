class Pair {
    int r, c;
    Pair(int a, int b) {
        r = a;
        c = b;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[] dirR = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dirC = {-1, 0, 1, 1, 1, 0, -1, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        grid[0][0] = 1; // mark visited

        int pathLen = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int r = p.r;
                int c = p.c;

                if (r == n - 1 && c == n - 1) return pathLen;

                for (int j = 0; j < 8; j++) {
                    int newRow = r + dirR[j];
                    int newCol = c + dirC[j];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
            pathLen++;
        }

        return -1; // no path found
    }
}
