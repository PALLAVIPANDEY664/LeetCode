class Solution {
    public int compress(char[] chars) {

        int n = chars.length;
        int idx = 0;   // position to write compressed characters

        for (int i = 0; i < n; i++) {

            char ch = chars[i];
            int count = 0;

            // count consecutive characters
            while (i < n && chars[i] == ch) {
                count++;
                i++;
            }

            // store character
            chars[idx++] = ch;

            // store count if >1
            if (count > 1) {
                String num = Integer.toString(count);
                for (char c : num.toCharArray()) {
                    chars[idx++] = c;
                }
            }

            i--;  // adjust because for loop will increment
        }

        return idx;
    }
}