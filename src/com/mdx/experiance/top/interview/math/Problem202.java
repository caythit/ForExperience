package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/5
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem202 {
    public boolean isHappy(int n) {
        List<Integer> sumList = new ArrayList<>();
        while (true) {
            int sum = sumNumBitSquare(n);
            if (sum == 1) {
                return true;
            }

            if (sumList.contains(sum)) {
                return false;
            }
            sumList.add(sum);
            n = sum;
        }
    }

    /**
     * 数字每位的平方和
     *
     * @param n
     * @return
     */
    private int sumNumBitSquare(int n) {
        Integer sum = 0;
        while (n > 0) {
            Integer tmp = n % 10;
            sum = sum + tmp * tmp;
            n = n / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        Problem202 problem = new ProblemConstructBuilder<Problem202>(Problem202.class.getName()).build();
        System.out.println(problem.isHappy(19));

    }
}
