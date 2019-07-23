package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;

/**
 * 实现描述：
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < nums.length) {
//                nums[nums[i]] = nums[i];
//            }
//        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[nums.length - 1] +1;
    }

    public static void main(String[] args) {
        Problem268 problem = new ProblemConstructBuilder<Problem268>(Problem268.class.getName()).build();
//        System.out.println(problem.missingNumber(new int[]{3, 0, 1}));
        System.out.println(problem.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
