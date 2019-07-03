package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, 0, 0, n, "");
        return res;
    }

    /**
     * @param res
     * @param left
     * @param right
     * @param n
     */
    private void generateParenthesis(List<String> res, int left, int right, int n, String s) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) {
            generateParenthesis(res, left + 1, right, n, s + "(");
        }
        if (right < left) {
            generateParenthesis(res, left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        Problem22 problem22 = new ProblemConstructBuilder<Problem22>(Problem22.class.getName()).build();
        for (String s : problem22.generateParenthesis(3)) {
            System.out.println(s);
        }
    }
}
