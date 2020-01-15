package com.mdx.experiance.top.interview.string;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;

/**
 * 实现描述：
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * <p>
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> digitLetterMap = initDigitLetterMap();

        //预处理 去除无映射关系的数字
        String validSigits = "";
        for (int i = 0; i < digits.length(); i++) {
            if (digitLetterMap.get(digits.charAt(i)) != null) {
                validSigits += digits.charAt(i);
            }
        }

        // 特殊情况1
        if (validSigits.length() == 0) {
            return res;
        }
        // 特殊情况2
        if (validSigits.length() == 1) {
            res.addAll(splitString2List(digitLetterMap.get(validSigits.charAt(0))));
            return res;
        }

        List<String> st1 = splitString2List(digitLetterMap.get(validSigits.charAt(0)));
        String st2 = digitLetterMap.get(validSigits.charAt(1));
        List<String> combineLetterList = splitStr4CombineList(st1, st2);

        for (int i = 2; i < validSigits.length(); i++) {
            String st = digitLetterMap.get(validSigits.charAt(i));
            combineLetterList = splitStr4CombineList(combineLetterList, st);
        }
        return combineLetterList;
    }

    /**
     * 打散字符串 将其各个字母拼接到list的每个字符串后面
     *
     * @param s1
     * @param s2
     * @return
     */
    private List<String> splitStr4CombineList(List<String> s1, String s2) {
        List<String> newS1 = new ArrayList<>();
        for (String s : s1) {
            for (int i = 0; i < s2.length(); i++) {
                String ss = s;
                ss += s2.charAt(i);
                newS1.add(ss);
            }
        }
        return newS1;
    }

    /**
     * 遍历字符串 以链表形式返回
     *
     * @param s
     * @return
     */
    private List<String> splitString2List(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            res.add(s.charAt(i) + "");
        }
        return res;
    }

    /**
     * @return
     */
    private Map<Character, String> initDigitLetterMap() {
        Map<Character, String> digitLetterMap = new HashMap<>();
        digitLetterMap.put('2', "abc");
        digitLetterMap.put('3', "def");
        digitLetterMap.put('4', "ghi");
        digitLetterMap.put('5', "jkl");
        digitLetterMap.put('6', "mno");
        digitLetterMap.put('7', "pqrs");
        digitLetterMap.put('8', "tuv");
        digitLetterMap.put('9', "wxyz");
        return digitLetterMap;
    }

    public static void main(String[] args) {
        Problem17 problem17 = new ProblemConstructBuilder<Problem17>(Problem17.class.getName()).build();
        for (String s : problem17.letterCombinations("2")) {
            System.out.println(s);
        }
        for (String s : problem17.letterCombinations("23")) {
            System.out.println(s);
        }

        for (String s : problem17.letterCombinations("234")) {
            System.out.println(s);
        }
    }

    class Solution {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

        List<String> output = new ArrayList<String>();

        public void backtrack(String combination, String next_digits) {
            // if there is no more digits to check
            if (next_digits.length() == 0) {
                // the combination is done
                output.add(combination);
            }
            // if there are still digits to check
            else {
                // iterate over all letters which map
                // the next available digit
                String digit = next_digits.substring(0, 1);
                String letters = phone.get(digit);
                for (int i = 0; i < letters.length(); i++) {
                    String letter = phone.get(digit).substring(i, i + 1);
                    // append the current letter to the combination
                    // and proceed to the next digits
                    backtrack(combination + letter, next_digits.substring(1));
                }
            }
        }

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0)
                backtrack("", digits);
            return output;
        }
    }
}
