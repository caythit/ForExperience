package com.mdx.experiance.top.interview.dp;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem55 {
    /**
     * 数组起点能否跳到数组尾部，数组的每一个元素代表其能跳的距离
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        boolean[] canJump = new boolean[len];
        canJump[0] = true;
        for (int i = 0; i < len; i++) {
            int j = i + 1, times = nums[i];

            while (times-- > 0 && j < len) {
                canJump[j++] = true;
            }
            if (canJump[i] == false) {
                return false;
            }
            if (canJump[len - 1] == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem55 problem = new ProblemConstructBuilder<Problem55>(Problem55.class.getName()).build();
        System.out.println(problem.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(problem.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(problem.canJump(new int[]{1, 0, 1, 0}));
    }
}
