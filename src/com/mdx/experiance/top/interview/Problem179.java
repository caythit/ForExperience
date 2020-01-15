package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;
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
@Info(status = StatusEnum.ACCEPTTED)
public class Problem179 {
    public String largestNumber(int[] nums) {
        List<String> numStrList = new ArrayList<>();
        for (int i : nums) {
            String s = String.valueOf(i);
            numStrList.add(s);
        }

        numStrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
//                int o1Len = o1.length(), o2Len = o2.length();
//                if (o1Len == o2Len) {
//                    return o1.compareTo(o2);
//                } else {
//                    int minLen = Math.min(o1Len, o2Len);
//                    // 截取统一长度比较
//                    int com = o1.substring(0, minLen).compareTo(o2.substring(0, minLen));
//                    if (com != 0) {
//                        return com;
//                    } else {
//                        // 虚拟扩充长度比较
//                        String newO1 = String.join("", Collections.nCopies(o2Len, o1));
//                        String newO2 = String.join("", Collections.nCopies(o1Len, o2));
//                        return newO1.compareTo(newO2);
//                    }
//                }
            }
        });
        if (numStrList.get(numStrList.size() - 1).equals("0")) {
            return "0";
        }
        String s = "";
        for (int i = numStrList.size() - 1; i >= 0; i--) {
            s += numStrList.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        Problem179 problem = new ProblemConstructBuilder<Problem179>(Problem179.class.getName()).build();
        System.out.println(problem.largestNumber(new int[]{3, 30}));
        System.out.println(problem.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(problem.largestNumber(new int[]{128, 12}));
        System.out.println(problem.largestNumber(new int[]{34, 3}));
        System.out.println(problem.largestNumber(new int[]{0, 0}));
        System.out.println(problem.largestNumber(new int[]{1, 0, 0}));
        System.out.println(problem.largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
        System.out.println(problem.largestNumber(new int[]{12, 121}));
    }

}
