package com.mdx.experiance.top.interview.sort;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        // 翻转位置 最小值所在位置
        Integer rotateIndex = findRotateIndexV2(nums);

        if (nums[rotateIndex] == target) {
            return rotateIndex;
        } else if (nums[rotateIndex] > target) {
            return -1;
        } else {
            Integer res = searchBinary(0, rotateIndex - 1, nums, target);
            if (res == -1) {
                return searchBinary(rotateIndex, nums.length - 1, nums, target);
            }
            return res;
        }
    }

    /**
     * 二分查找 顺序数组
     *
     * @param st
     * @param et
     * @param nums
     * @param target
     * @return
     */
    private int searchBinary(Integer st, Integer et, int[] nums, int target) {
        while (st <= et) {
            int mid = (st + et) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                et = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 找出翻转位置 也就是最小值所在的索引
     * 时间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    private Integer findRotateIndex(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                return i;
            }
        }
        return nums[0] < nums[nums.length - 1] ? 0 : nums.length - 1;
    }

    /**
     * 找出翻转位置 也就是最小值所在的索引
     * 时间复杂度 O(logN)
     *
     * @param nums
     * @return
     */
    private Integer findRotateIndexV2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[mid + 1] < nums[mid]) {
            return mid + 1;
        }
        // 说明没有过翻转
        return 0;

    }

    public static void main(String[] args) {
        Problem33 problem33 = new ProblemConstructBuilder<Problem33>(Problem33.class.getName()).build();
//        System.out.println(problem33.searchBinary(0, 3, new int[]{1, 3, 5}, 1));
//        System.out.println(problem33.findRotateIndexV2(new int[]{1, 3, 5}));
        System.out.println(problem33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(problem33.findRotateIndexV2(new int[]{4, 5, 6, 7, 0, 1, 2}));
//        System.out.println(problem33.search(new int[]{3, 1}, 1));
//        System.out.println(problem33.search(new int[]{1}, 0));
    }
}
