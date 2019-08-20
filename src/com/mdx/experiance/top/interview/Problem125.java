package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;

/**
 * 实现描述：
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        String alphas = filterCases(s);
        StringBuilder sb = new StringBuilder(alphas);
        sb.reverse();
        return alphas.equals(sb.toString());
    }


    private String filterCases(String s) {
        String st = "";
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                st += c;
            }
        }
        return st.toLowerCase();
    }

    public static void main(String[] args) {
        Problem125 problem = new ProblemConstructBuilder<Problem125>(Problem125.class.getName()).build();
//        System.out.println(problem.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(problem.isPalindrome("OP"));
    }
}
