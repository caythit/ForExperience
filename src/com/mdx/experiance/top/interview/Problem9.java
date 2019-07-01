package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        return x == reverse(x);
    }

    /**
     * 反转数字
     *
     * @param x
     * @return
     */
    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            Integer tenCn = countTenTimes(x);
            Integer multiTen = getTenMi(tenCn);

            res = res + (x % 10 * multiTen);
            x = x / 10;
        }
        return res;

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
        Problem9 problem9 = new ProblemConstructBuilder<Problem9>(Problem9.class.getName()).build();
        System.out.println(problem9.isPalindrome(1000021));
        System.out.println(problem9.isPalindrome(12321));
        System.out.println(problem9.isPalindrome(121));
        System.out.println(problem9.isPalindrome(-121));
        System.out.println(problem9.isPalindrome(10));
        System.out.println(problem9.isPalindrome(0));

    }
}
