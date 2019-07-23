package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现描述：
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/18
 */
public class Problem179 {
    public String largestNumber(int[] nums) {
        List<String> numStrList = new ArrayList<>();
        for (int i : nums) {
            String s = String.valueOf(i);
            numStrList.add(s);
        }

        numStrList.sort((s1,s2) -> s2.compareTo(s1));

        System.out.println("9A".compareTo("99"));
        return "";
    }

    public static void main(String[] args) {
        Problem179 problem = new ProblemConstructBuilder<Problem179>(Problem179.class.getName()).build();
        System.out.println(problem.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
