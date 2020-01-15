package com.mdx.experiance.top.interview.backtrack;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/6
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem79 {
    /**
     * 在二维数组中找出是否存在word，数组元素可以上下左右相邻的拼接，但一个元素只能用一次
     * 有点像屏幕解锁
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (exist(board, word, 0, i, j, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int idx, int i, int j, boolean[][] isVisited) {
        System.out.println("i=" + i + ",j=" + j + ",idx=" + idx);
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        // 已经访问过
        if (isVisited[i][j] == true) {
            return false;
        }

        if (board[i][j] == word.charAt(idx)) {
            isVisited[i][j] = true;
            if (exist(board, word, idx + 1, i - 1, j, isVisited) || exist(board, word, idx + 1, i + 1, j, isVisited)
                    || exist(board, word, idx + 1, i, j - 1, isVisited) || exist(board, word, idx + 1, i, j + 1, isVisited)) {
                return true;
            } else {
                isVisited[i][j] = false;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Problem79 problem = new ProblemConstructBuilder<Problem79>(Problem79.class.getName()).build();
//        System.out.println(problem.exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCCED"));
        System.out.println(problem.exist(new char[][]{
                {'A', 'A'}
        }, "AAA"));
    }
}
