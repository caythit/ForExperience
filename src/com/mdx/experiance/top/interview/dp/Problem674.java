package com.mdx.experiance.top.interview.dp;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/5
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem674 {
    /**
     * 无序的数组，找出最长连续递增子序列，不可跳元素
     * 如[1,3,5,4,7]的结果是[1,3,5]；[2,2,2,2,2]的结果是[2]
     * 注意和题目300的区别
     * <p>
     * 时间复杂度O(1) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1, tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                tmp = 1;
                continue;
            }
            tmp++;
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem674 problem = new ProblemConstructBuilder<Problem674>(Problem674.class.getName()).build();
        System.out.println(problem.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
