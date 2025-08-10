import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        
        Set<String> powerSignatures = new HashSet<>();
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 fits in int range
            int power = 1 << i;
            powerSignatures.add(sortDigits(power));
        }
        
        return powerSignatures.contains(target);
    }
    
    private String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
