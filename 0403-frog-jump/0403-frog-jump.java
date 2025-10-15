import java.util.*;

class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    boolean canJump(int index, int lastJump, int[] stones, Map<Integer, Integer> pos) {
        if (index == stones.length - 1)
            return true;

        String key = index + "," + lastJump;
        if (memo.containsKey(key))
            return memo.get(key);

        for (int nextJump = lastJump - 1; nextJump <= lastJump + 1; nextJump++) {
            if (nextJump <= 0) continue; // can't jump 0 or negative
            int nextPos = stones[index] + nextJump;
            if (pos.containsKey(nextPos)) {
                if (canJump(pos.get(nextPos), nextJump, stones, pos)) {
                    memo.put(key, true);
                    return true;
                }
            }
        }

        memo.put(key, false);
        return false;
    }

    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false; // first jump must be 1

        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < stones.length; i++)
            pos.put(stones[i], i);

        return canJump(1, 1, stones, pos);
    }
}
