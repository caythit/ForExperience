package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/17
 */
public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        while (k > 1) {
            k--;
        }
        return 1;
    }

    public static void main(String[] args) {
        Problem378 problem = new ProblemConstructBuilder<Problem378>(Problem378.class.getName()).build();
        System.out.println(problem.kthSmallest(new int[][]{
                {1, 5, 9},
                {6, 10, 11},
                {7, 13, 15}
        }, 7));
    }
}
