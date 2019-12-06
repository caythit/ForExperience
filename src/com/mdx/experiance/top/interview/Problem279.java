package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/9/3
 */
public class Problem279 {
    public int numSquares(int n) {
        Integer num = 0;
        while (n > 0) {
            Integer edge = findEdge(n);
            n = n - edge * edge;
            num++;
        }
        return num;
    }

    private Integer findEdge(int n) {
        int x = 1;
        while (x * x <= n) {
            x++;
        }
        return x - 1;
    }

    public static void main(String[] args) {
        Problem279 problem = new ProblemConstructBuilder<Problem279>(Problem279.class.getName()).build();
        System.out.println(problem.numSquares(12));
        System.out.println(problem.numSquares(13));
    }
}
