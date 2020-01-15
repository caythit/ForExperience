package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/28
 */
public class Problem171 {
    public int titleToNumber(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Integer factor = 1;
        Integer res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res += (s.charAt(i) - 'A' + 1) * factor;
            factor = factor * 26;
        }
        return res;
    }


    public static void main(String[] args) {
        Problem171 problem = new ProblemConstructBuilder<Problem171>(Problem171.class.getName()).build();
        System.out.println(problem.titleToNumber("ZY"));
    }
}
