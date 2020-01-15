package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/20
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, r = x;
        while (l < r) {
            int mid = (l + r) / 2;
            if (x / mid >= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r - 1;
    }

    public static void main(String[] args) {
        Problem69 problem = new ProblemConstructBuilder<Problem69>(Problem69.class.getName()).build();
        System.out.println(problem.mySqrt(5));
        System.out.println(problem.mySqrt(10));
    }
}
