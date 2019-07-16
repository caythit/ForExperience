package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 实现描述：
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/16
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return sets.size() != nums.length;
    }

    public static void main(String[] args) {
        Problem217 problem = new ProblemConstructBuilder<Problem217>(Problem217.class.getName()).build();
        System.out.println(problem.containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(problem.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(problem.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
