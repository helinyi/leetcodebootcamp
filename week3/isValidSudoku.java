package week3;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRolCol(board, i))
                return false;
        }
        // int row = 0; int col = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBox(board, i, j))
                    return false;
            }
        }

        return true;
    }

    private boolean checkRolCol(char[][] board, int row) {
        int[] countRol = new int[9];
        int[] countCol = new int[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][row] != '.') {
                int rowValue = board[i][row] - '1';
                if (countRol[rowValue] != 0) {
                    return false;
                }
                countRol[rowValue]++;
            }
            if (board[row][i] != '.') {
                int colValue = board[row][i] - '1';
                if (countCol[colValue] > 0) {
                    return false;
                }
                countCol[colValue]++;
            }
        }
        return true;
    }

    private boolean checkBox(char[][] board, int row, int col) {
        int[] countBox = new int[9];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    int boxVal = board[i][j] - '1';
                    if (countBox[boxVal] != 0) {
                        return false;
                    }
                    countBox[boxVal]++;
                }
            }
        }
        return true;
    }
}
