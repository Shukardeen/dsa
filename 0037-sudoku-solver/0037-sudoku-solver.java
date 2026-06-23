class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // recursive function
    boolean solve(char[][] board) {
        // find out the empty cell
        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                if(board[row][col] == '.') {
                    // check if a char can be placed in this empty cell or not
                    for(char c='1'; c<= '9'; c++) {
                        if(isValid(board, row, col, c)) {
                            // if valid then put in the board
                            board[row][col] = c;

                            // recursive call to the function
                            if(solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // function to validate the char in empty cell
    boolean isValid(char[][] board, int row, int col, char c) {
        for(int i=0; i<9; i++) {
            // check if the row contains current char or not
            if(board[row][i] == c) return false;
            // check if the column contains current char or not
            if(board[i][col] == c) return false;
            // check if the 3*3 sub-box contains the current char or not
            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == c) return false;
        }
        return true;
    }
}