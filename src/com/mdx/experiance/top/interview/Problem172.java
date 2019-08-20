package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
public class Problem172 {
    public int trailingZeroes(int n) {
        for (int i = 1; i <= n; i++) {
//            if()
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem172 problem = new ProblemConstructBuilder<Problem172>(Problem172.class.getName()).build();
        System.out.println(problem.trailingZeroes(3));
        System.out.println(problem.trailingZeroes(5));
    }
}
