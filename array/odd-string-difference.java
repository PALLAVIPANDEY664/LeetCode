class Solution {
     public String oddString(String[] words) {
        int n = words.length;

        // Get diff arrays for first 3 words
        int[] diff1 = getDiff(words[0]);
        int[] diff2 = getDiff(words[1]);
        int[] diff3 = getDiff(words[2]);

        int[] majority;

        // Find the majority difference pattern
        if (Arrays.equals(diff1, diff2) || Arrays.equals(diff1, diff3)) {
            majority = diff1;
        } else {
            return words[0];  // word[0] is the odd one
        }

        // Compare with majority and return the odd string
        for (String word : words) {
            if (!Arrays.equals(getDiff(word), majority)) {
                return word;
            }
        }
        return ""; // should never reach here
    }

    private int[] getDiff(String word) {
        int n = word.length();
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }
}