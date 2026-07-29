class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int prev2 = 1; // Base case for dp[i-2]
        int prev1 = 1; // Base case for dp[i-1]

        for (int i = 1; i < n; i++) {
            int current = 0;
            
            // Single-digit check (1 to 9)
            int singleDigit = s.charAt(i) - '0';
            if (singleDigit >= 1 && singleDigit <= 9) {
                current += prev1;
            }

            // Two-digit check (10 to 26)
            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                current += prev2;
            }

            // Update variables for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}