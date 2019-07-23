package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem283 {
    public void moveZeroes(int[] nums) {
        Integer v = 0;
        for (int k : nums) {
            if (k != 0) {
                nums[v++] = k;
            }
        }
        for (int i = v; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Problem283 problem = new ProblemConstructBuilder<Problem283>(Problem283.class.getName()).build();
        problem.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
