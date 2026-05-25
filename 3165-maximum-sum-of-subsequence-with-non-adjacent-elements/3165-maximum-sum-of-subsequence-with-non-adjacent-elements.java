class Solution {

    static class Node {

        long[][] dp;

        Node() {
            dp = new long[2][2];

            for (int i = 0; i < 2; i++) {
                Arrays.fill(dp[i], Long.MIN_VALUE);
            }
        }
    }

    Node[] seg;
    int[] nums;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {

        int n = nums.length;

        this.nums = nums;

        seg = new Node[4 * n];

        build(1, 0, n - 1);

        long ans = 0;

        int MOD = 1_000_000_007;

        for (int[] q : queries) {

            int pos = q[0];
            int val = q[1];

            update(1, 0, n - 1, pos, val);

            long best = 0;

            Node root = seg[1];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    best = Math.max(best, root.dp[i][j]);
                }
            }

            ans = (ans + best) % MOD;
        }

        return (int) ans;
    }

    void build(int idx, int l, int r) {

        seg[idx] = new Node();

        if (l == r) {

            seg[idx].dp[0][0] = 0;
            seg[idx].dp[1][1] = Math.max(0, nums[l]);

            return;
        }

        int mid = (l + r) / 2;

        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);

        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    void update(int idx, int l, int r, int pos, int val) {

        if (l == r) {

            seg[idx] = new Node();

            seg[idx].dp[0][0] = 0;
            seg[idx].dp[1][1] = Math.max(0, val);

            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(idx * 2, l, mid, pos, val);
        } else {
            update(idx * 2 + 1, mid + 1, r, pos, val);
        }

        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1]);
    }

    Node merge(Node A, Node B) {

        Node res = new Node();

        for (int aL = 0; aL < 2; aL++) {
            for (int aR = 0; aR < 2; aR++) {
                for (int bL = 0; bL < 2; bL++) {
                    for (int bR = 0; bR < 2; bR++) {

                        if (aR == 1 && bL == 1)
                            continue;

                        if (A.dp[aL][aR] == Long.MIN_VALUE ||
                            B.dp[bL][bR] == Long.MIN_VALUE)
                            continue;

                        res.dp[aL][bR] = Math.max(
                                res.dp[aL][bR],
                                A.dp[aL][aR] + B.dp[bL][bR]
                        );
                    }
                }
            }
        }

        return res;
    }
}