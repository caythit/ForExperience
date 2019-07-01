package com.mdx.experiance.problem;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

/**
 * 实现描述：
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/1
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem35 {
    /**
     * 从给定的数组中，找出给定值应该插入的位置
     * 说明：
     * （1）数组中无重复数
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < target) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem35 problem35 = new ProblemConstructBuilder<Problem35>(Problem35.class.getName()).build();
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
