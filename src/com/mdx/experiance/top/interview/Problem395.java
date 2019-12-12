package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "aaabb", k = 3
 * <p>
 * Output:
 * 3
 * <p>
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input:
 * s = "ababbc", k = 2
 * <p>
 * Output:
 * 5
 * <p>
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
public class Problem395 {
    /**
     * 最长的子串，使得其中的字符个数至少重复K次
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s.isEmpty() || k > s.length()) {
            return 0;
        }
        if (k == 1) {
            return s.length();
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.containsKey(c) ? countMap.get(c) + 1 : 1);
        }

        int[] times = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            times[i] = countMap.get(s.charAt(i));
        }

        Integer max = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] >= k) {
                continue;
            }


        }
        return 0;
    }

    public static void main(String[] args) {
        Problem395 problem = new ProblemConstructBuilder<Problem395>(Problem395.class.getName()).build();
        System.out.println(problem.longestSubstring("ababbc", 2));
    }

}
