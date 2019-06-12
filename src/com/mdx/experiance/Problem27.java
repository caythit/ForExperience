package com.mdx.experiance;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

/**
 * 实现描述：
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
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
 * int len = removeElement(nums, val);
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
public class Problem27 {
    /**
     * 数组去除给定值 返回剩余数组的长度
     * 说明：
     * （1）在原地操作 不能使用额外的数组空间 空间复杂度O(1)
     * （2）注意看上面的Clarification，问题需要实际变更数组，后台判定时会根据返回的长度以及实际数组来看结果
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     *
     * @param nums
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        Integer cn = 0;
        Integer index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            cn++;
            nums[index++] = nums[i];
        }
        return cn;
    }

    public static void main(String[] args) {
        Problem27 problem27 = new ProblemConstructBuilder<Problem27>(Problem27.class.getName()).build();
        System.out.println(problem27.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
