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
@Info(status = StatusEnum.TRYING)
public class Problem48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        /**
         * 规律：
         * (0,0)->(0,n-0)
         * (0,1)->(1,n-0)
         * (0,2)->(2,n-0)
         * (0,3)->(3,n-0)
         *
         * (1,0)->(0,n-1)
         * (1,1)->(1,n-1)
         * (1,2)->(2,n-1)
         * (1,3)->(3,n-1)
         *
         * (2,0)->(0,n-2)
         * (2,1)->(1,n-2)
         * (2,2)->(2,n-2)
         * (2,3)->(3,n-2)
         *
         * .....
         */

        int m = n;
        for (int i = 0; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                swap(i, j, j, n - i, matrix);
            }
            m--;
        }
    }

    /**
     * @param i
     * @param j
     * @param newI
     * @param newJ
     */
    private void swap(int i, int j, int newI, int newJ, int[][] matrix) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[newI][newJ];
        matrix[newI][newJ] = tmp;
    }

    public static void main(String[] args) {
        Problem48 problem = new ProblemConstructBuilder<Problem48>(Problem48.class.getName()).build();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        problem.rotate(matrix);

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        problem.rotate(matrix);
        int j = 0;
    }
}
