package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
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
@Info(status = StatusEnum.ACCEPTTED)
public class Problem279 {
    /**
     * 寻找最少平方根的个数之和等于某个数
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] != 1) {
                dp[i] = Integer.MAX_VALUE;
                for (int k = 1; k * k <= i; k++) {
                    dp[i] = Math.min(dp[k * k] + dp[i - k * k], dp[i]);
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Problem279 problem = new ProblemConstructBuilder<Problem279>(Problem279.class.getName()).build();
        System.out.println(problem.numSquares(12));
        System.out.println(problem.numSquares(13));
    }
}
