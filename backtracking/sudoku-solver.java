class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        int n = board.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false; // no number fits
                }
            }
        }
        return true; // solved
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {

        // Row & Column check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) return false;
            if (board[i][col] == ch) return false;
        }

        // 3×3 sub-grid check
        int rowStart = row - row % 3;
        int colStart = col - col % 3;

        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == ch) return false;
            }
        }
        return true;
    }
}
