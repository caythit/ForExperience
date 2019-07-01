package com.mdx.experiance.problem;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

/**
 * 实现描述：
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/30
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem26 {
    /**
     * 已排序的数组去除相同的元素 返回剩余数组的长度
     * 说明：
     * （1）在原地操作 不能使用额外的数组空间,空间复杂度O(1)
     * （2）第一次做的时候仅仅是统计不同的数字并返回，并没有改动数组，导致未通过
     * 注意看上面的Clarification，问题需要实际变更数组，后台判定时会根据返回的长度以及实际数组来看结果
     *
     * Runtime: 1 ms, faster than 99.76% of Java online submissions for Remove Duplicates from Sorted Array.
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Integer cn = 1;
        Integer index = 0;
        Integer start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (start == nums[i]) {
                continue;
            }
            cn++;
            start = nums[i];
            nums[++index] = nums[i];
        }
        return cn;
    }

    public static void main(String[] args) {
        Problem26 problem26 = new ProblemConstructBuilder<Problem26>(Problem26.class.getName()).build();
        System.out.println(problem26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
