package com.mdx.experiance.problem;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

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
@Info(status = StatusEnum.WRONG_ANSWER)
@Mark
public class Problem33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }

        // 翻转位置 最小值所在位置
        Integer rotateIndex = findRotateIndex(nums);
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
                st = mid + 1;
            } else {
                et = mid - 1;
            }
        }
        return -1;

    }

    /**
     * 找出翻转位置
     *
     * @param nums
     * @return
     */
    private Integer findRotateIndex(int[] nums) {
        return findRotateIndex(0, nums.length, nums);
    }

    /**
     * 找出翻转位置 最小值所在索引
     *
     * @param left
     * @param right
     * @param nums
     * @return
     */
    private Integer findRotateIndex(int left, int right, int[] nums) {
        int mid = (left + right) >> 1;
        if (mid != 0 && mid != nums.length - 1 &&
                nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
            return mid;
        }
        if (nums[mid] > nums[left]) {
            return findRotateIndex(mid, right, nums);
        }
        return findRotateIndex(left, mid, nums);
    }

    public static void main(String[] args) {
        Problem33 problem33 = new ProblemConstructBuilder<Problem33>(Problem33.class.getName()).build();

        System.out.println(problem33.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
