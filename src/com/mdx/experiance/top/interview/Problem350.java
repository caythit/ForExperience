package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现描述：
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1Map = countNumTime(nums1);
        Map<Integer, Integer> nums2Map = countNumTime(nums2);

        List<Integer> r = new ArrayList<>();
        for (Integer key : nums1Map.keySet()) {
            if (nums2Map.containsKey(key)) {
                Integer min = Math.min(nums1Map.get(key), nums2Map.get(key));
                while (min-- > 0) {
                    r.add(key);
                }
            }
        }
        return  r.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Map<Integer, Integer> countNumTime(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Problem350 problem = new ProblemConstructBuilder<Problem350>(Problem350.class.getName()).build();
        for (int i : problem.intersect(new int[]{1, 2, 1}, new int[]{1, 2, 2})) {
            System.out.println(i);
        }
    }
}
