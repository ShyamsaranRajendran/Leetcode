class Pair {
    int node;
    long weight;
    Pair(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    static int MOD = (int)1e9 + 7;

    public int countPaths(int n, int[][] roads) {
 
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); 
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->Long.compare(a.weight, b.weight));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            long  d = cur.weight;

            if (d > dist[u]) continue;
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                long wt = neighbor.weight;

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    ways[v] = ways[u];
                    pq.add(new Pair(v, dist[v]));
                } else if (dist[u] + wt == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
