package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can,
 * there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/9
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem189 {

    /**
     * 时间复杂度 O（k*n）
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        while (k-- > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 时间复杂度 O（n）
     *
     * @param nums
     * @param k
     */
    public void rotateV2(int[] nums, int k) {
        k = k % nums.length;
        rotateV2(nums, 0, nums.length - k - 1);
        rotateV2(nums, nums.length - k, nums.length - 1);
        rotateV2(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * @param nums
     * @param start
     * @param end
     */
    private void rotateV2(int[] nums, int start, int end) {
        while (start < end && start >= 0) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Problem189 problem = new ProblemConstructBuilder<Problem189>(Problem189.class.getName()).build();
//        problem.rotateV2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        problem.rotateV2(new int[]{1, 2, 3}, 4);
    }
}
