package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/4
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                if (i == 0) {
                    if (!isColumnValid(board, j)) {
                        return false;
                    }
                }
                if (j == 0) {
                    if (!isRowValid(board, i)) {
                        return false;
                    }
                }
                if (i % 3 == 0 && j % 3 == 0) {
                    if (!isSubBoxValid(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 对比子块
     *
     * @param board
     * @param row
     * @param column
     * @return
     */
    private boolean isSubBoxValid(char[][] board, int row, int column) {
        String res = "";
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!res.contains(c + "")) {
                    res += c;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 对比column
     * 变行的索引 列的索引固定=column
     *
     * @param board
     * @param column
     * @return
     */
    private boolean isColumnValid(char[][] board, int column) {
        String res = "";
        for (int k = 0; k < board[0].length; k++) {
            char c = board[k][column];
            if (c == '.') {
                continue;
            }
            if (!res.contains(c + "")) {
                res += c;
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 对比row
     * 行的索引固定=row 列的索引变动
     *
     * @param board
     * @param row
     * @return
     */
    private boolean isRowValid(char[][] board, int row) {
        String res = "";
        for (int k = 0; k < board.length; k++) {
            char c = board[row][k];
            if (c == '.') {
                continue;
            }
            if (!res.contains(c + "")) {
                res += c;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem36 problem = new ProblemConstructBuilder<Problem36>(Problem36.class.getName()).build();
        char[][] board = initSudoku();
        System.out.println(problem.isValidSudoku(board));


    }

    private static char[][] initSudoku() {
        char[][] board0 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        return board0;
    }
}
