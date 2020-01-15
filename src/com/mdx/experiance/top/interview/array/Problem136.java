package com.mdx.experiance.top.interview.array;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;

/**
 * 实现描述：Given a non-empty array of integers,
 * every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/22
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem136 {
    /**
     * 数组：两两重复 只有一个落单
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int st = nums[0];
        int id = 0;
        for (int i = 1; i < nums.length; i++) {
            if (st == nums[i]) {
                continue;
            }
            // 不等 前后
            else {
                if (i == id + 1) {
                    return nums[id];
                } else {
                    st = nums[i];
                    id = i;
                }
            }
        }
        return nums[id];
    }

    public static void main(String[] args) {
        Problem136 problem = new ProblemConstructBuilder<Problem136>(Problem136.class.getName()).build();
        System.out.println(problem.singleNumber(new int[]{2, 2, 1}));
        System.out.println(problem.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
