package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/17
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem53 {

    public int maxSubArray(int[] nums) {
        Integer positiveIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveIdx = i;
                break;
            }
        }
        int[] dp = new int[nums.length - positiveIdx];
        dp[0] = nums[positiveIdx];
        Integer max = nums[positiveIdx], j = 1;
        for (int i = positiveIdx + 1; i < nums.length; i++) {
            dp[j] = Math.max(dp[j - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[j]);
            j++;
        }
        return max;
    }

    /**
     * 最大连续递增子串和
     *
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums) {
        Integer max = nums[0];
        Integer cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            if(max < cur) {
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem53 problem = new ProblemConstructBuilder<Problem53>(Problem53.class.getName()).build();
        System.out.println(problem.maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
