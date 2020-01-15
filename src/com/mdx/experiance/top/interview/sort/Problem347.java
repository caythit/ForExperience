package com.mdx.experiance.top.interview.sort;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;

/**
 * 实现描述：
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }

        List<Map.Entry<Integer, Integer>> cnList = new ArrayList<>(map.entrySet());
        cnList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> cn : cnList) {
            if (k > 0) {
                res.add(cn.getKey());
            }
            k--;
        }
        return res;

    }

    public static void main(String[] args) {
        Problem347 problem = new ProblemConstructBuilder<Problem347>(Problem347.class.getName()).build();
        for (int i : problem.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)) {
            System.out.println(i);
        }
    }
}
