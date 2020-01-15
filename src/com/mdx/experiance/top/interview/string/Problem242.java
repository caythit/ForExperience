package com.mdx.experiance.top.interview.string;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;

/**
 * 实现描述：
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem242 {
    /**
     * 所谓 anagram, 就是两个词所用的字母及其个数都是一样的
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        Arrays.sort(sc);
        return new String(sc).equals(new String(tc));
    }

    public static void main(String[] args) {
        Problem242 problem = new ProblemConstructBuilder<Problem242>(Problem242.class.getName()).build();
        System.out.println(problem.isAnagram("anagram", "nagaram"));
    }
}
