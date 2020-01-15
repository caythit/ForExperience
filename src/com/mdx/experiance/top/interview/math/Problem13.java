package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem13 {
    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = initRomanMap();
        Integer res = 0;
        Integer i = 0;
        for (i = 0; i < s.length() - 1; i++) {
            Integer post = romanMap.get(s.charAt(i + 1));
            Integer pre = romanMap.get(s.charAt(i));
            if (post.equals(pre)) {
                res += post;
                res += pre;
                i++;
            } else if (post < pre) {
                res += pre;
            } else {
                res += (romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i)));
                i++;
            }
        }
        return i == s.length() - 1 ? res + romanMap.get(s.charAt(i)) : res;
    }

    private Map<Character, Integer> initRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }

    public static void main(String[] args) {
        Problem13 problem13 = new ProblemConstructBuilder<Problem13>(Problem13.class.getName()).build();
        System.out.println(problem13.romanToInt("III"));
        System.out.println(problem13.romanToInt("IV"));
        System.out.println(problem13.romanToInt("IX"));
        System.out.println(problem13.romanToInt("LVIII"));
        System.out.println(problem13.romanToInt("MCMXCIV"));
    }
}
