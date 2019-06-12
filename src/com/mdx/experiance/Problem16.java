package com.mdx.experiance;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

import java.util.Arrays;

/**
 * 实现描述：
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/24
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem16 {

    /**
     * 找出数组中三个数字之和 与 给定值 最为接近的组合 返回这个组合的sum值
     * 说明：
     * （1）数组中的每个值只能出现一次
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        Integer initSum = nums[0] + nums[1] + nums[2];
        Integer initDiff = Math.abs(target - initSum);
        out:
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - sum);

                // break 出去
                if (diff == 0) {
                    initSum = sum;
                    break out;
                }

                if (initDiff > diff) {
                    initDiff = diff;
                    initSum = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }

            }

        }
        return initSum;
    }


    public static void main(String[] args) {
        Problem16 problem16 = new ProblemConstructBuilder<Problem16>(Problem16.class.getName()).build();
        System.out.println(problem16.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
    }
}
