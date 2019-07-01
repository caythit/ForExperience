package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/13
 */
public class Problem5 {
    /**
     * 找出字符串中最长的回文
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String rs = stringBuilder.reverse().toString();

        if (s.equals(rs)) {
            return s;
        }

        return longestCommonStr(s, rs);
    }

    /**
     * 两个字符串的最长公共子串
     *
     * @param s1
     * @param s2
     * @return
     */
    private String longestCommonStr(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        // 初始化
        for (int i = 0; i < s1.length(); i++) {
            dp[0][i] = (s1.charAt(i) == s2.charAt(0)) ? 1 : 0;
        }
        for (int j = 0; j < s2.length(); j++) {
            dp[j][0] = (s1.charAt(0) == s2.charAt(j)) ? 1 : 0;
        }

        //记录dp中最大数出现第一次时的i或者j的位置
        int ki = 0;
        int kj = 0;
        int max = 0;

        // 填充dp 按行
        for (int j = 1; j < s2.length(); j++) {
            for (int i = 1; i < s1.length(); i++) {
                if (s2.charAt(j) == s1.charAt(i)) {
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                    if (max < dp[j][i]) {
                        ki = i;
                        kj = j;
                        max = dp[j][i];
                    }

                } else {
                    dp[j][i] = 0;
                }
            }
        }

        // 打印dp看看
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }

        String res = "";
        // 获取结果 ki表示dp哪一列 kj表示dp哪一行 按行取 循环列 遇到不是0的直接结束
        for (int i = max; i > 0; i--) {
            res += s1.charAt(ki--);
        }
        if ("".equals(res)) {
            return s1.charAt(0) + "";
        }
        return res;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new ProblemConstructBuilder<Problem5>(Problem5.class.getName()).build();
//        System.out.println(problem5.longestPalindrome("ac"));
//        System.out.println(problem5.longestPalindrome("babbad"));
//        System.out.println(problem5.longestPalindrome("babad"));
//        System.out.println(problem5.longestPalindrome("abbbbd"));
//        System.out.println(problem5.longestPalindrome("bbbb"));
//        System.out.println(problem5.longestPalindrome("abb"));
//        System.out.println(problem5.longestPalindrome("babadada"));
        System.out.println(problem5.longestPalindrome("aacdefcaa"));
    }
}
