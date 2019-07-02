package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String s1 = strs[0];
        String s2 = strs[1];

        String commonPrefix = longestCommonPrefix(s1, s2);

        for (int i = 2; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    /**
     * 两个字符串的最长前缀串
     *
     * @param s1
     * @param s2
     * @return
     */
    private String longestCommonPrefix(String s1, String s2) {
        Integer shortLen = Math.min(s1.length(), s2.length());

        String res = "";
        for (int i = 0; i < shortLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            res = res + s1.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem14 problem14 = new ProblemConstructBuilder<Problem14>(Problem14.class.getName()).build();
        System.out.println(problem14.longestCommonPrefix(new String[]{"flower", "flow", "flight" }));
        System.out.println(problem14.longestCommonPrefix(new String[]{"dog", "racecar", "car" }));
    }
}
