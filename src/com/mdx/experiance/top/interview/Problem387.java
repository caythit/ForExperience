package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;

/**
 * 实现描述：
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem387 {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> cn = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            cn.put(c, cn.containsKey(c) ? cn.get(c) + 1 : 1);
        }
        if (cn.isEmpty()) {
            return -1;
        }
        for (char c : cn.keySet()) {
            if (cn.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem387 problem = new ProblemConstructBuilder<Problem387>(Problem387.class.getName()).build();
        System.out.println(problem.firstUniqChar("aadadaad"));
    }
}

