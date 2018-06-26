package interviewPickings.leetcode;

import java.util.HashSet;

public class ValidateSudoku_36 {
    public static void main(String[] args) {
        ValidateSudoku_36 validate = new ValidateSudoku_36();
//        char[][] sudoku = new char[][]{
//                {5, 3, 0,  0, 7, 0,  0, 0, 0},
//                {6, 0, 0,  1, 9, 5,  0, 0, 0},
//                {0, 9, 8,  0, 0, 0,  0, 6, 0},
//
//                {8, 0, 0,  0, 6, 0,  0, 0, 3},
//                {4, 0, 0,  8, 0, 3,  0, 0, 1},
//                {7, 0, 0,  0, 2, 0,  0, 0, 6},
//
//                {0, 6, 0,  0, 0, 0,  2, 8, 0},
//                {0, 0, 0,  4, 1, 9,  0, 0, 5},
//                {0, 0, 0,  0, 8, 0,  0, 7, 9}
//
//        };

        char[][] sudoku = new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        };
        System.out.println(validate.isValidSudoku(sudoku));
        System.out.println(validate.isValidSudoku2(sudoku));

    }

    private boolean isValidSudoku(char[][] board) {
        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        int idx;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}



