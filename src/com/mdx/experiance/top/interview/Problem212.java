package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/6
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem212 {

    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;

        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean[][] isVisited = new boolean[row][col];
            out: for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (exist(board, word, i, j, 0, isVisited)) {
                        res.add(word);
                        break out;
                    }
                }
            }
        }
        return res;
    }


    private boolean exist(char[][] board, String word, int i, int j, int idx, boolean[][] isVisited) {
        System.out.println("i=" + i + ",j=" + j + ",idx=" + idx);

        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (isVisited[i][j] == true) {
            return false;
        }

        if (board[i][j] == word.charAt(idx)) {
            isVisited[i][j] = true;
            if (exist(board, word, i - 1, j, idx + 1, isVisited) ||
                    exist(board, word, i + 1, j, idx + 1, isVisited) ||
                    exist(board, word, i, j - 1, idx + 1, isVisited) ||
                    exist(board, word, i, j + 1, idx + 1, isVisited)) {
                return true;
            } else {
                isVisited[i][j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem212 problem = new ProblemConstructBuilder<Problem212>(Problem212.class.getName()).build();
        System.out.println(problem.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}
        }, new String[]{"oath", "pea", "eat", "rain"}));

//        System.out.println(problem.findWords(new char[][]{
//                {'a', 'a'}
//        }, new String[]{"aaa"}));
    }
}
