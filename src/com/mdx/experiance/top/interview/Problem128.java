package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 实现描述：Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/5
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem128 {
    /**
     * 无序的数组，找出最长连续的子序列，原数组的顺序可以随意打乱，只要保证是连续+1即可
     * 时间复杂度 O(N)
     * 注意，和题目300、题目674的对比
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        Integer longest = 0;
        for (int num : nums) {
            Integer tmp = num;
            Integer longer = 1;

            while (numSet.contains(tmp + 1)) {
                tmp = tmp + 1;
                longer++;
            }
            longest = Math.max(longest, longer);
        }
        return longest;
    }

    public static void main(String[] args) {
        Problem128 problem = new ProblemConstructBuilder<Problem128>(Problem128.class.getName()).build();
        System.out.println(problem.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
