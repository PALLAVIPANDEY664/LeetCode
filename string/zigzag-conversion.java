class Solution {
    public String convert(String s, int numRows) {
        // Base case: if there's only 1 row, or the string is shorter than the rows,
        // the zigzag pattern is identical to the original string.
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Turn around if we hit the top row (0) or bottom row (numRows - 1)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down depending on the direction
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single final string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}