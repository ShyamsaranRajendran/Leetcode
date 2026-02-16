class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // Extract last bit
            int bit = n & 1;

            // Shift result left and add extracted bit
            res = (res << 1) | bit;

            // Shift input right
            n >>= 1;
        }

        return res;
    }
}
