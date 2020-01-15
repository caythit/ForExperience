package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * Could you solve it in linear time?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/24
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1 || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE, maxIdx = 0;
        for (int i = 0; i < k; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }
        res[0] = max;

        int j = 1;
        for (int right = k; right < nums.length; right++) {
            if (right - maxIdx < k) {
                res[j++] = Math.max(nums[right], nums[maxIdx]);
                maxIdx = nums[right] > nums[maxIdx] ? right : maxIdx;
            } else {
                int tmp = nums[right];
                maxIdx = right;
                for (int l = right - k + 1, r = right - 1; l <= r; l++) {
                    if (nums[l] > tmp) {
                        tmp = nums[l];
                        maxIdx = l;
                    }

                }
                res[j++] = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem239 problem = new ProblemConstructBuilder<Problem239>(Problem239.class.getName()).build();
//        problem.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        problem.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
    }

}
