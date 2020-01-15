package com.mdx.experiance.top.interview.other;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Stack;

/**
 * 实现描述：Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                numStack.push(b + a);
            } else if ("-".equals(s)) {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                numStack.push(b - a);

            } else if ("*".equals(s)) {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                numStack.push(b * a);
            } else if ("/".equals(s)) {
                Integer a = numStack.pop();
                Integer b = numStack.pop();
                numStack.push(b / a);
            } else {
                numStack.push(Integer.valueOf(s));
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        Problem150 problem = new ProblemConstructBuilder<Problem150>(Problem150.class.getName()).build();
        System.out.println(problem.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(problem.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(problem.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
