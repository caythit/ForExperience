package com.mdx.experiance.top.interview.sort;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/9
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem75 {
    /**
     * 时间复杂度 O(n) 空间复杂度O(1)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur < right) {


            if (nums[cur] == 2) {
                swap(cur, right, nums);
                right--;
            }
            if (nums[cur] == 0) {
                swap(cur, left, nums);
                left++;
            }
            cur++;
        }
        int i = 0;
    }

    private void swap(int left, int right, int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        Problem75 problem = new ProblemConstructBuilder<Problem75>(Problem75.class.getName()).build();
        problem.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        problem.sortColors(new int[]{1, 0, 2, 1, 1, 0});
        problem.sortColors(new int[]{1, 1, 2, 1, 1, 2});
        problem.sortColors(new int[]{0, 2});
        problem.sortColors(new int[]{1, 0, 1});
    }
}
