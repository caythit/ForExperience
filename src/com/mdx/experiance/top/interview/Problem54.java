package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/7
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem54 {
    /**
     * 螺旋遍历二维数组
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            // 1,2,3
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }

            // 6,9
            for (int i = r1 + 1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }

            if (r1 < r2 && c1 < c2) {
                // 8
                for (int i = c2 - 1; i > c1; i--) {
                    res.add(matrix[r2][i]);
                }

                // 7,4
                for (int i = r2; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }

            r1++;
            c1++;
            r2--;
            c2--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem54 problem = new ProblemConstructBuilder<Problem54>(Problem54.class.getName()).build();

        problem.spiralOrder(new int[][]{
                {1},
                {2}
        });
        problem.spiralOrder(new int[][]{
                {1, 2, 3}
        });

        problem.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
//
        problem.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });

        problem.spiralOrder(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        });
    }
}
