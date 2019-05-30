package com.meituan.experiance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现描述：
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/20
 */
public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // key为减过后的值 value为下标
        Map<Integer, Integer> minusIndex = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            minusIndex.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (minusIndex.get(nums[i]) != null && minusIndex.get(nums[i]) != i) {
                result[0] = i;
                result[1] = minusIndex.get(nums[i]);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new ProblemConstructBuilder<Problem1>(Problem1.class.getName()).build();

        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] result = problem1.twoSum(nums, target);
        for (int r : result) {
            System.out.println(r);
        }
    }
}
