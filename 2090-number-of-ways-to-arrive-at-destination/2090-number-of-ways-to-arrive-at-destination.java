import java.util.*;

class Solution {
    static class Pair {
        int node;
        long time;

        Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Step 1: Build graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            long t = road[2];
            adj.get(u).add(new Pair(v, t));
            adj.get(v).add(new Pair(u, t));
        }

        // Step 2: Dijkstra init
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Pair(0, 0));

        // Step 3: Dijkstra with path count
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long time = curr.time;

            if (time > dist[u]) continue;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                long edgeTime = neighbor.time;

                if (dist[v] > dist[u] + edgeTime) {
                    dist[v] = dist[u] + edgeTime;
                    ways[v] = ways[u];
                    pq.add(new Pair(v, dist[v]));
                } else if (dist[v] == dist[u] + edgeTime) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}