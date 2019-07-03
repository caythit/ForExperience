package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.LinkedList;
import java.util.List;

/**
 * 实现描述：
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/3
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem28 {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (!"".equals(haystack) && needle.length() > haystack.length()) {
            return -1;
        }
        char c = needle.charAt(0);
        List<Integer> indexList = new LinkedList<>();

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == c) {
                indexList.add(i);
            }
        }

        String tmp = haystack;
        for (Integer index : indexList) {
            Integer end = Math.min(index + needle.length(), tmp.length());
            String sub = tmp.substring(index, end);
            if (sub.equals(needle)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem28 problem28 = new ProblemConstructBuilder<Problem28>(Problem28.class.getName()).build();
        System.out.println(problem28.strStr("hello", "ll"));
//        System.out.println(problem28.strStr("aaaaa", "bba"));
        System.out.println(problem28.strStr("", "issipi"));
//        System.out.println(problem28.strStr("aaa", "aaaa"));
    }
}
