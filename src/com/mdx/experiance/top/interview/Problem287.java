package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/29
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Problem287 problem287 = new ProblemConstructBuilder<Problem287>(Problem287.class.getName()).build();

        System.out.println(problem287.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
