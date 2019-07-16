package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/16
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnMap = new HashMap<>();
        for (int i : nums) {
            cnMap.put(i, cnMap.containsKey(i) ? cnMap.get(i) + 1 : 1);
        }
        for (Integer k : cnMap.keySet()) {
            if (cnMap.get(k) > nums.length / 2) {
                return k;
            }
        }
        return 0;
    }

    /**
     * 因为一定存在 所以可以直接取中位数
     *
     * @param nums
     * @return
     */
    public int majorityElementV2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Problem169 problem = new ProblemConstructBuilder<Problem169>(Problem169.class.getName()).build();
        System.out.println(problem.majorityElement(new int[]{3, 2, 3}));
        System.out.println(problem.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
