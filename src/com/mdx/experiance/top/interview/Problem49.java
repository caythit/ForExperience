package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 实现描述：
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/31
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, String> strMap = new HashMap<>(strs.length);
        List<List<String>> resultAll = new ArrayList<>();

        for (Integer i = 0; i < strs.length; i++) {
            String sortStr = sortStr(strs[i]);
            strMap.put(sortStr, strMap.containsKey(sortStr) ? strMap.get(sortStr) + "->" + i : i.toString());
        }
        for (String str : strMap.keySet()) {
            resultAll.add(Arrays.asList(strMap.get(str).split("->")).stream().map(x -> strs[Integer.valueOf(x)]).collect(Collectors.toList()));
        }

        return resultAll;
    }

    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

    public static void main(String[] args) {
        Problem49 problem = new ProblemConstructBuilder<Problem49>(Problem49.class.getName()).build();
        for (List<String> stringList : problem.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            for (String str : stringList) {
                System.out.print(str + "->");
            }
            System.out.println();
        }

        for (List<String> stringList : problem.groupAnagrams(new String[]{"", ""})) {
            for (String str : stringList) {
                System.out.print(str + "->");
            }
            System.out.println();
        }
    }

}
