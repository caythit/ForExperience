package com.meituan.experiance;

import java.util.Arrays;

/**
 * 实现描述：给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/9
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        if (len == 0) {
            return 1;
        }
        if (len == 1) {
            if (nums[0] != 1) {
                return 1;
            }
            return 2;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > len || nums[i] <= 0) {
                continue;
            }
            nums[nums[i] - 1] = nums[i];

        }

        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        Problem41 problem41 = new ProblemConstructBuilder<Problem41>(Problem41.class.getName()).build();
        System.out.println(problem41.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(problem41.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(problem41.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(problem41.firstMissingPositive(new int[]{2, 2}));
        System.out.println(problem41.firstMissingPositive(new int[]{2, 1}));
    }
}
