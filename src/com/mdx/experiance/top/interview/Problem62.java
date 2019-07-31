package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/28
 */
public class Problem62 {

    public int uniquePaths(int m, int n) {
        Integer sum = 0;
        uniquePaths(0, 0, m - 1, n - 1, sum);
        return sum;
    }

    private void uniquePaths(int stRow, int stCol, int m, int n, Integer sum) {
        if (stRow == m && stCol == n - 1) {
            sum += 1;
        }
        if (stCol == n && stRow == m - 1) {
            sum += 1;
        }

        for (int i = stRow; i < m; i++) {
            uniquePaths(i + 1, stCol, m, n, sum);
        }
        for (int j = stCol; j < n; j++) {
            uniquePaths(stRow, j + 1, m, n, sum);
        }
    }

    public static void main(String[] args) {
        Problem62 problem = new ProblemConstructBuilder<Problem62>(Problem62.class.getName()).build();
        System.out.println(problem.uniquePaths(3, 2));
//        System.out.println(problem.uniquePaths(7, 3));
    }
}
