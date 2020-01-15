package com.mdx.experiance.top.interview.dp;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/17
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer i = 1, j = 2;
        Integer sum = 0;
        while (n >= 3) {
            sum = i + j;
            i = j;
            j = sum;
            n--;
        }
        return sum;
    }

    /**
     * 超时
     * n=44时 有1134903170走法
     *
     * @param n
     * @return
     */
    public int climbStairsV2(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairsV2(n - 1) + climbStairsV2(n - 2);
    }

    public static void main(String[] args) {
        Problem70 problem = new ProblemConstructBuilder<Problem70>(Problem70.class.getName()).build();
        System.out.println(problem.climbStairs(44));
    }
}
