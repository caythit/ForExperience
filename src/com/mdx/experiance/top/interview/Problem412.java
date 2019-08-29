package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/28
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem412 {

    static String FIZZ = "Fizz";
    static String BUZZ = "Buzz";
    static String FIZZBUZZ = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.add(FIZZ);
            } else if (i % 3 != 0 && i % 5 == 0) {
                res.add(BUZZ);
            } else if (i % 3 == 0 && i % 5 == 0) {
                res.add(FIZZBUZZ);
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem412 problem = new ProblemConstructBuilder<Problem412>(Problem412.class.getName()).build();
        for (String s : problem.fizzBuzz(15)) {
            System.out.println(s);
        }
    }
}
