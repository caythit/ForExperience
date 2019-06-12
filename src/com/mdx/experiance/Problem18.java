package com.mdx.experiance;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

import java.util.*;

/**
 * 实现描述：
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/28
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem18 {

    /**
     * 找出数组中四个数字之和 等于 给定值的 所有组合情况
     * 说明：
     * （1）不能返回相同的组合，比如[0,0,1,0]、[0,1,0,0] 被认为是同样的组合
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultAll = new LinkedList<>();

        Arrays.sort(nums);

        List<Integer> alreadyCalc = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(alreadyCalc.contains(nums[i])) {
                continue;
            }
            int minus = target - nums[i];

            List<List<Integer>> result = threeSum(nums, i, minus);
            if (result.size() > 0) {
                for (List<Integer> r : result) {
                    r.add(nums[i]);
                }
                resultAll.addAll(result);
            }
            alreadyCalc.add(nums[i]);
        }
        return resultAll;
    }

    /**
     * 三数之和 等于target
     *
     * @param nums   数组
     * @param start  数组的起始位置
     * @param target 目标值
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> resultAll = new LinkedList<>();
        List<Integer> alreadyCalc = new ArrayList<>();

        for (int i = start + 1; i < nums.length; i++) {
            if(alreadyCalc.contains(nums[i])) {
                continue;
            }
            int minus = target - nums[i];

            List<List<Integer>> result = twoSum(nums, i, minus);
            if (result.size() > 0) {
                for (List<Integer> r : result) {
                    r.add(nums[i]);
                }
                resultAll.addAll(result);
            }
            alreadyCalc.add(nums[i]);

        }
        return resultAll;
    }

    /**
     * 找出所有不重复的两数 使其之和 等于target
     *
     * @param nums   数组
     * @param start  数组的起始位置
     * @param target 目标值
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> resultAll = new LinkedList<>();
        Map<Integer, Integer> minusMap = new HashMap<>();

        for (int i = start + 1; i < nums.length; i++) {
            int minus = target - nums[i];
            if (!minusMap.containsKey(minus)) {
                minusMap.put(minus, i);
            }
        }

        List<Integer> usedValue = new LinkedList<>();
        for (int i = start + 1; i < nums.length; i++) {
            // 下标重复过滤 已经使用过的值过滤
            if (minusMap.containsKey(nums[i]) && minusMap.get(nums[i]) != i && !usedValue.contains(nums[i])) {
                List<Integer> result = new LinkedList<>();
                result.add(nums[i]);
                result.add(target - nums[i]);
                resultAll.add(result);

                usedValue.add(nums[i]);
                usedValue.add(target - nums[i]);
            }
        }
        return resultAll;
    }

    public static void main(String[] args) {
        Problem18 problem18 = new ProblemConstructBuilder<Problem18>(Problem18.class.getName()).build();

//        List<List<Integer>> result = problem18.fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
//        result.forEach(r -> r.forEach(x -> System.out.println(x)));

        List<List<Integer>> result1 = problem18.fourSum(new int[]{-3,-2,-1,0,0,1,2,3,0}, 0);
        result1.forEach(r -> r.forEach(x -> System.out.println(x)));


    }
}
