class Pair {
    int row, col, effort;

    Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int row = current.row, col = current.col, effort = current.effort;

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}