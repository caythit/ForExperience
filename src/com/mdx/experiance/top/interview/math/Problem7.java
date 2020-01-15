package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem7 {
    /**
     * 给定32位有符号的证书，返回其翻转后的整数
     * 共1032个实例，有1030个实例通过
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE / 2) {
            return 0;
        }

        Boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }

        Integer res = 0;
        x = Math.abs(x);
        while (x > 0) {
            Integer ys = x % 10;
            if (ys != 0) {
                Integer tenCn = countTenTimes(x);
                Integer multiTen = getTenMi(tenCn);
                res = res + (ys * multiTen);
            }
            x = x / 10;
        }
        return isNeg ? -1 * res : res;
    }

    /**
     * 多个十相乘
     *
     * @param tenCn
     * @return
     */
    private Integer getTenMi(Integer tenCn) {
        Integer res = 1;
        while (tenCn > 0) {
            res = res * 10;
            tenCn--;
        }
        return res;
    }

    /**
     * 计算一个数字是通过多少个十相乘的
     *
     * @param x
     * @return
     */
    private Integer countTenTimes(int x) {
        Integer res = 0;
        while (x / 10 > 0) {
            res++;
            x = x / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new ProblemConstructBuilder<Problem7>(Problem7.class.getName()).build();
        System.out.println(problem7.reverse(123));
        System.out.println(problem7.reverse(-123));
        System.out.println(problem7.reverse(120));
        System.out.println(problem7.reverse(1534236469));

        System.out.println(Math.pow(2.0f, 31.0f) / 2);
    }
}
