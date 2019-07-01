package com.mdx.experiance.problem;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

/**
 * 实现描述：
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/30
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem34 {

    /**
     * 升序数组中找出等于给定值的开始以及结束下标 如果没有则返回[-1,-1]
     * 说明：
     * （1）时间复杂度必须为O(logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int left = 0, right = nums.length - 1;
        int pos = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }

        if (pos == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        result[0] = pos;
        result[1] = pos;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            result[1] = i;
        }
        for (int i = pos; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            result[0] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem34 problem34 = new ProblemConstructBuilder<Problem34>(Problem34.class.getName()).build();
//        int[] result = problem34.searchRange(new int[]{1}, 1);
//        for (int r : result) {
//            System.out.println(r);
//        }
//        for (int r : problem34.searchRange(new int[]{5,7,7,8,8,10},6)) {
//            System.out.println(r);
//
//        }



        for (int r : problem34.searchRange(new int[]{1,1, 2}, 1)) {
            System.out.println(r);

        }
    }
}

