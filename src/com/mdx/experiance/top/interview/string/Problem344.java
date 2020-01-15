package com.mdx.experiance.top.interview.string;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Write a function that reverses a string.
 * The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/14
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem344 {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        Integer i = 0, j = s.length - 1;
        while (i <= j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        Problem344 problem = new ProblemConstructBuilder<Problem344>(Problem344.class.getName()).build();
        problem.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
