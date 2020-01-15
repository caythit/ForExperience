package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现描述：Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/19
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem152 {
    /**
     * 连续的子序列，使得乘积最大
     * O(n)
     *
     * @param nums
     * @return
     */
    public int maxProductV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxDp[i] = Math.max(nums[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], maxDp[i - 1] * nums[i]);
            } else {
                maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
            }
            max = Math.max(max, maxDp[i]);
        }
        return max;
    }

    /**
     * 连续的子序列，使得乘积最大
     * 共184个用例，通过183个，超时一个
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> prodList = new ArrayList<>();
        prodList.add(nums[0]);
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            final int num = nums[i];
            List<Integer> prodNewList = prodList.stream().map(x -> x * num).collect(Collectors.toList());
            prodNewList.add(nums[i]);
            prodList = prodNewList;
            max = Math.max(prodList.stream().max(Integer::compare).get(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem152 problem = new ProblemConstructBuilder<Problem152>(Problem152.class.getName()).build();
        System.out.println(problem.maxProduct(new int[]{2, 3, -2, 4}));

    }
}
