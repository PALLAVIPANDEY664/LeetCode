class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        
        // Step 1: Precompute bitmasks and lengths for each word
        for (int i = 0; i < n; i++) {
            lens[i] = words[i].length();
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            masks[i] = mask;
        }
        
        int maxProd = 0;
        
        // Step 2: Compare every pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If they share no common letters, their bitwise AND will be 0
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, lens[i] * lens[j]);
                }
            }
        }
        
        legends:
        return maxProd;
    }
}