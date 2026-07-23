import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        // A valid IP address length must be between 4 and 12 characters
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int parts, StringBuilder current, List<String> result) {
        // Base Case: If 4 parts are formed and the entire string is processed
        if (parts == 4) {
            if (index == s.length()) {
                // Remove trailing dot
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        // Each segment can have a length of 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) {
                break;
            }

            String segment = s.substring(index, index + len);

            // Segment cannot start with '0' unless it's just "0"
            if (segment.length() > 1 && segment.startsWith("0")) {
                break;
            }

            // Segment value cannot exceed 255
            int val = Integer.parseInt(segment);
            if (val > 255) {
                break;
            }

            // Backtrack: Choose -> Recurse -> Unchoose
            int lengthBefore = current.length();
            current.append(segment).append('.');

            backtrack(s, index + len, parts + 1, current, result);

            current.setLength(lengthBefore);
        }
    }
}