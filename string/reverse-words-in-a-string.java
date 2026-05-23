public class Solution {
    public String reverseWords(String s) {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        // Iterate backwards through the array of words
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            
            // Add a space between words, but not after the last word
            if (i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}