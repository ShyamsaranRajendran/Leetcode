public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        int maxLength = Math.max(v1Parts.length, v2Parts.length);
        int[] v1 = new int[maxLength];
        int[] v2 = new int[maxLength];
        
        for (int i = 0; i < v1Parts.length; i++) {
            v1[i] = Integer.parseInt(v1Parts[i]);
        }
        
        for (int i = 0; i < v2Parts.length; i++) {
            v2[i] = Integer.parseInt(v2Parts[i]);
        }
        
        for (int i = 0; i < maxLength; i++) {
            if (v1[i] < v2[i]) {
                return -1;
            } else if (v1[i] > v2[i]) {
                return 1;
            }
        }
        
        return 0;
    }
}