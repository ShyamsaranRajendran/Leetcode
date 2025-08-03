import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // Base case: if we already have 4 parts
        if (path.size() == 4) {
            // Check if we used all characters
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            // Skip invalid numbers
            if ((part.startsWith("0") && part.length() > 1) || Integer.parseInt(part) > 255) {
                continue;
            }

            path.add(part);
            backtrack(s, index + len, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
