package com.mdx.experiance.top.interview.other;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Stack;

/**
 * 实现描述：Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/5
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem227 {
    /**
     * 表达式计算
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Integer result = 0;
        Stack<Integer> myStack = new Stack<>();

        String num = "";
        char preOpr = '+';
        s = s + "+";

        for (Integer i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                num += c;
            } else {
                if (preOpr == '+') {
                    myStack.push(Integer.valueOf(num));
                } else if (preOpr == '-') {
                    myStack.push(-1 * Integer.valueOf(num));
                } else if (preOpr == '*') {
                    myStack.push(myStack.pop() * Integer.valueOf(num));
                } else if (preOpr == '/') {
                    myStack.push(myStack.pop() / Integer.valueOf(num));
                }
                preOpr = c;
                num = "";

            }
        }

        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }
        return result;

    }

    public static void main(String[] args) {
        Problem227 problem = new ProblemConstructBuilder<Problem227>(Problem227.class.getName()).build();
        System.out.println(problem.calculate("3+2*2"));
        System.out.println(problem.calculate("3+2*2+3"));
        System.out.println(problem.calculate("3/2"));
        System.out.println(problem.calculate("3+5 / 2"));
        System.out.println(problem.calculate("42/3"));
    }
}
