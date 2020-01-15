package com.mdx.experiance.top.interview.other;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Stack;

/**
 * 实现描述：
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> pariStack = new Stack<>();
        boolean isValid = true;
        for (int i = 0; i < s.length(); i++) {
            if (isLeftPari(s.charAt(i))) {
                pariStack.push(s.charAt(i));
                continue;
            }
            if (isRightPari(s.charAt(i))) {
                if(pariStack.empty()) {
                    isValid = false;
                    break;
                }
                char c = pariStack.pop();
                if (!isValidPair(c, s.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid && pariStack.empty();

    }

    /**
     * 左右匹配
     *
     * @param c
     * @param c1
     * @return
     */
    private boolean isValidPair(char c, char c1) {
        return (c == '(' && c1 == ')') || (c == '[' && c1 == ']') || (c == '{' && c1 == '}');
    }

    /**
     * 是否左
     *
     * @param c
     * @return
     */
    private boolean isLeftPari(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    /**
     * 是否右
     *
     * @param c
     * @return
     */
    private boolean isRightPari(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static void main(String[] args) {
        Problem20 problem20 = new ProblemConstructBuilder<Problem20>(Problem20.class.getName()).build();
//        System.out.println(problem20.isValid("(()("));
        System.out.println(problem20.isValid("]"));
    }
}
