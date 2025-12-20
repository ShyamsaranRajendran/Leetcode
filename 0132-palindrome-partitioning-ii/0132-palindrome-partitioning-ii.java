import java.util.Arrays;

class Solution {

    boolean[][] pal;
    int[] dp;

    void buildPal(String s) {
        int n = s.length();
        pal = new boolean[n][n];

        for (int i = 0; i < n; i++) pal[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) pal[i][j] = true;
                    else pal[i][j] = pal[i + 1][j - 1];
                }
            }
        }
    }

    int func(int ind, String s) {
        if (ind == s.length()) return 0;
        if (dp[ind] != -1) return dp[ind];

        int minPartitions = Integer.MAX_VALUE;

        for (int i = ind; i < s.length(); i++) {
            if (pal[ind][i]) {
                minPartitions = Math.min(
                    minPartitions,
                    1 + func(i + 1, s)
                );
            }
        }

        return dp[ind] = minPartitions;
    }

    public int minCut(String s) {
        int n = s.length();
        if (n == 0) return 0;

        buildPal(s);

        dp = new int[n];
        Arrays.fill(dp, -1);

        return func(0, s) - 1;
    }
}
