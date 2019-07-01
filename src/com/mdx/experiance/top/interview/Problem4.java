package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/23
 */
@Info(status = StatusEnum.WRONG_ANSWER)
@Mark
public class Problem4 {

    /**
     * 找出两个已排序数组合并后的中位数
     * 说明：
     * （1）时间复杂度必须为 O(log (m+n))
     * （2）数组不会同时为空
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        // 根据总长度奇偶来定义中位数起始位置
        int startIndex = totalLen % 2 == 0 ? totalLen / 2 - 1 : totalLen / 2;

        // 特殊 某个数组为空
        if (isNullArrays(nums1, nums2)) {
            if (nums1.length == 0) {
                return nums2[startIndex];
            } else {
                return nums1[startIndex];
            }
        }

        if (nums1.length == 1 && nums2.length == 1) {
            return (nums1[0] + nums2[0]) / 2.0;
        }

        if (isMaxLessMin(nums1, nums2)) {

        }

        int i = 0, j = 0;
        // 循环比对两个数组 根据大小获取实际中位数下标
        for (; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }

            if (i == startIndex || j == startIndex) {
                break;
            }
        }
        return judgeMedian(i, j, nums1, nums2, totalLen);

    }

    /**
     * 特殊数组 某个最大 小于 某个最小
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private boolean isMaxLessMin(int[] nums1, int[] nums2) {
        return nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0];
    }

    /**
     * 特殊数组 其中一个为空
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private boolean isNullArrays(int[] nums1, int[] nums2) {
        return nums1.length == 0 || nums2.length == 0;
    }

    /**
     * 根据位置裁决中位数
     *
     * @param i
     * @param j
     * @param nums1
     * @param nums2
     * @return
     */
    public double judgeMedian(int i, int j, int[] nums1, int[] nums2, int totalLen) {
        if (totalLen % 2 != 0) {
            return Math.min(nums1[i], nums2[j]);
        } else {
            // 都不在起始位置
            if (i != 0 && j != 0) {
                return (nums1[i] + nums2[j]) / 2.0;
            }
            // 有一个在起始位置 另一个不在终点位置
            if (i == 0 && j != nums2.length - 1) {
                return (Math.min(nums1[i], nums2[j + 1]) + nums2[j]) / 2.0;

            }
            // 有一个在起始位置 另一个不在终点位置
            if (j == 0 && i != nums1.length - 1) {
                return (nums1[i] + Math.min(nums1[i + 1], nums2[j])) / 2.0;

            }
            // 一个起始位置 一个终点位置
            return (nums1[i] + nums2[j]) / 2.0;
        }

    }

    public static void main(String[] args) {
        Problem4 problem4 = new ProblemConstructBuilder<Problem4>(Problem4.class.getName()).build();


        System.out.println(problem4.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(problem4.findMedianSortedArrays(new int[]{2}, new int[]{1}));
        System.out.println(problem4.findMedianSortedArrays(new int[]{1, 3}, new int[]{4}));
        System.out.println(problem4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
        System.out.println(problem4.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));

        System.out.println(problem4.findMedianSortedArrays(new int[]{1}, new int[]{2, 4}));
        System.out.println(problem4.findMedianSortedArrays(new int[]{2, 3}, new int[]{1}));
    }
}
