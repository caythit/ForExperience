package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现描述：You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/25
 */
public class Problem315 {
    /**
     * 通过，491 ms
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cn = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    cn++;
                }
            }
            res.add(cn);
        }
        return res;
    }

    public List<Integer> countSmallerV2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] sortArr = new int[nums.length];
        Arrays.fill(sortArr, Integer.MAX_VALUE);

        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = insertSortArr(sortArr, nums[i]);
            res.add(idx);
        }
        return res;
    }

    /**
     * 数字插入已排序的数组 返回下标
     * [1,6] 2 返回1，数组变成[1,2,6]
     *
     * @param sortArr
     * @param num
     * @return
     */
    private int insertSortArr(int[] sortArr, int num) {
        int l = 0, r = sortArr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (sortArr[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        for (int i = sortArr.length - 1; i > l; i--) {
            sortArr[i] = sortArr[i - 1];
        }
        sortArr[l] = num;
        return l;
    }

    public static void main(String[] args) {
        Problem315 problem = new ProblemConstructBuilder<Problem315>(Problem315.class.getName()).build();
        problem.countSmaller(new int[]{5, 2, 6, 1});
        problem.countSmallerV2(new int[]{5, 2, 6, 1});
    }

}