class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // 1. Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert characters to integer and handle overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Check for 32-bit signed integer overflow/underflow
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}