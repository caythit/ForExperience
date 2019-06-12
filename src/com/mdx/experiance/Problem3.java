package com.mdx.experiance;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/10
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem3 {
    /**
     * 找出字符串中最长的无重复字母的子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        String res = "";
        List<String> notRepeatStr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!res.contains(s.charAt(i) + "")) {
                res += s.charAt(i);
                continue;
            }
            if (notRepeatStr.contains(res)) {
                continue;
            }
            notRepeatStr.add(res);
            // 回到重复字母位置
            i = s.substring(0, i).lastIndexOf(res) + res.indexOf(s.charAt(i) + "");

            res = "";
        }
        notRepeatStr.add(res);

        Integer max = 0;
        res = "";
        for (String str : notRepeatStr) {
            if (max < str.length()) {
                max = str.length();
                res = str;
            }
        }
        System.out.println(res);
        return max;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new ProblemConstructBuilder<Problem3>(Problem3.class.getName()).build();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(problem3.lengthOfLongestSubstring("pwwkew"));
        System.out.println(problem3.lengthOfLongestSubstring("bbb"));
        System.out.println(problem3.lengthOfLongestSubstring("dvdf"));
        System.out.println(problem3.lengthOfLongestSubstring("umvejcuuk"));
        System.out.println(problem3.lengthOfLongestSubstring("lwphapjnadqhdcnvwdtxjbmypppha"));
        System.out.println(problem3.lengthOfLongestSubstring("abcdbbcdb"));
    }
}
