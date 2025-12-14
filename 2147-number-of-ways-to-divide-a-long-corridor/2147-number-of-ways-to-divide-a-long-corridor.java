class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int seats = 0;
        long ways = 1;
        int plantsBetween = 0;
        boolean countingPlants = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seats++;
                if (seats > 2 && seats % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
                countingPlants = seats % 2 == 0;
            } else if (c == 'P' && countingPlants) {
                plantsBetween++;
            }
        }

        return seats >= 2 && seats % 2 == 0 ? (int) ways : 0;
    }
}
