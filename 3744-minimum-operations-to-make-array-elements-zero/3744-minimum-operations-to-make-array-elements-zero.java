class Solution {
  public long minOperations(int[][] queries) {
    long ans = 0;
    for (int[] query : queries) {
      int l = query[0];
      int r = query[1];
      ans += (getOperations(r) - getOperations(l - 1) + 1) / 2;
    }
    return ans;
  }

  private long getOperations(int n) {
    long res = 0;
    int ops = 0;
    for (long base = 1; base <= n; base *= 4) {
      ops++;
      long start = base;
      long end = Math.min(n, base * 4 - 1);
      res += (end - start + 1) * ops;
    }
    return res;
  }
}
