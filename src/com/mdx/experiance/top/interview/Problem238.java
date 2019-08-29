package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/28
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] leftProducts = calcLeftElementsProducts(nums);

        int[] rightProducts = calcRightElementsProducts(nums);
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }
        return output;
    }

    public int[] productExceptSelfV2(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];

        }
        int R = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = R * output[i];
            R = R * nums[i];
        }
        return output;
    }

    /**
     * @param nums
     * @return
     */
    private int[] calcLeftElementsProducts(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        return res;
    }

    /**
     * @param nums
     * @return
     */
    private int[] calcRightElementsProducts(int[] nums) {
        int[] res = new int[nums.length];
        res[res.length - 1] = 1;
        for (int i = res.length - 2; i >= 0; i--) {
            res[i] = nums[i + 1] * res[i + 1];
        }
        return res;
    }


    public static void main(String[] args) {
        Problem238 problem = new ProblemConstructBuilder<Problem238>(Problem238.class.getName()).build();
        problem.productExceptSelfV2(new int[]{1, 2, 3, 4});
    }
}
