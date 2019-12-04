package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Note:
 * <p>
 * Your solution should be in logarithmic complexity.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/12
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem162 {
    /**
     * 比较恶心的一点就是特殊情况
     * （1）数组就一个元素 输出0
     * （2）数组升序 输出数组长度
     * （3）数组降序 输出0
     * <p>
     * 时间复杂度要求 O(logN) 可能存在多个峰值 返回任意一个下标
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // 存储所有的峰值
        List<Integer> res = new ArrayList<>();
        findPeakElement(nums, 0, len - 1, res);

        if (res.size() == 0) {
            if (nums[0] > nums[len - 1]) {
                return 0;
            }
            return len - 1;
        }
        return res.get(0);
    }


    private void findPeakElement(int[] nums, int st, int et, List<Integer> res) {
        Integer mid = (st + et) / 2;
        if (mid == st) {
            return;
        }
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            res.add(mid);
            return;
        }
        findPeakElement(nums, st, mid, res);
        findPeakElement(nums, mid, et, res);
    }

    public static void main(String[] args) {
        Problem162 problem = new ProblemConstructBuilder<Problem162>(Problem162.class.getName()).build();
//        System.out.println(problem.findPeakElement(new int[]{1}));
//        System.out.println(problem.findPeakElement(new int[]{3, 2, 1}));
//        System.out.println(problem.findPeakElement(new int[]{1, 2, 3, 4}));
//        System.out.println(problem.findPeakElement(new int[]{3, 4, 3, 2, 1}));
        System.out.println(problem.findPeakElement(new int[]{1, 2, 3, 1}));


//        System.out.println(problem.findPeakElement(new int[]{1, 2, 3, 1}));
//        System.out.println(problem.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
