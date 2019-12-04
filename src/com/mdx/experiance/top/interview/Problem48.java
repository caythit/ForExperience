package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/5
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        /**
         * 规律：
         * 外层先换 再切到内层
         * i为层数
         * (i, j) -> (n-j, i) -> (n-i, n-j) -> (j, n-i)
         */
        Integer loop = 0, m = n;
        while (loop <= n / 2) {
            for (int j = loop; j < m; j++) {
                int tmp = matrix[loop][j];
                matrix[loop][j] = matrix[n - j][loop];
                matrix[n - j][loop] = matrix[n - loop][n - j];
                matrix[n - loop][n - j] = matrix[j][n - loop];
                matrix[j][n - loop] = tmp;
            }
            m--;
            loop++;
        }

    }

    public static void main(String[] args) {
        Problem48 problem = new ProblemConstructBuilder<Problem48>(Problem48.class.getName()).build();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        problem.rotate(matrix);

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        problem.rotate(matrix);
    }
}
