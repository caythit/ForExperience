package com.mdx.experiance.top.interview.sort;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;

/**
 * 实现描述：Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 * <p>
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 * <p>
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/19
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem324 {
    /**
     * 无序数组排序，使得nums[0] < nums[1] > nums[2] < nums[3]
     * 奇数位置比两边大 偶数位置比两边小
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int[] leftNums = Arrays.copyOfRange(nums, 0, len % 2 == 0 ? len / 2 : len / 2 + 1);
        int[] rightNums = Arrays.copyOfRange(nums, len % 2 == 0 ? len / 2 : len / 2 + 1, len);

        for (int i = 0, j = leftNums.length - 1, k = rightNums.length - 1; i < len; i++) {
            if (i % 2 == 0 && j >= 0) {
                nums[i] = leftNums[j--];
            } else if (i % 2 == 1 && k >= 0) {
                nums[i] = rightNums[k--];
            }
        }
        return;
    }

    public static void main(String[] args) {
        Problem324 problem = new ProblemConstructBuilder<Problem324>(Problem324.class.getName()).build();
//        problem.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
//        problem.wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
//        problem.wiggleSort(new int[]{1, 1, 2, 1, 2, 2, 1});
        problem.wiggleSort(new int[]{4, 5, 5, 6});
        problem.wiggleSort(new int[]{5, 3, 1, 2, 6, 7, 8, 5, 5});
    }
}
