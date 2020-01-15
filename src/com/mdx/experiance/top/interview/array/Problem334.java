package com.mdx.experiance.top.interview.array;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/16
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem334 {
    /**
     * 无序的数组是否存在长度为3的递增子序列
     * 时间复杂度O(n^2) 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max >= 3;
    }

    /**
     * 无序的数组是否存在长度为3的递增子序列
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public boolean increasingTripletNew(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int minOne = Integer.MAX_VALUE, minTwo = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= minOne) minOne = num;
            else if (num < minTwo) minTwo = num;
            if(num > minTwo) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Problem334 problem = new ProblemConstructBuilder<Problem334>(Problem334.class.getName()).build();
        problem.increasingTripletNew(new int[]{1, 2, 3, 1, 2, 1});
    }
}
