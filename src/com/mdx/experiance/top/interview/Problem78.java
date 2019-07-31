package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/23
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> resAll = new ArrayList<>();
        subsets(0, nums, res, resAll);
        return resAll;
    }

    private void subsets(int st, int[] nums, List<Integer> res, List<List<Integer>> resAll) {
        if (res.size() <= nums.length) {
            resAll.add(new ArrayList<>(res));
        }

        for (int i = st; i < nums.length; i++) {
            res.add(nums[i]);
            subsets(i + 1, nums, res, resAll);
            res.remove(res.size() - 1);
        }
    }


    public static void main(String[] args) {
        Problem78 problem = new ProblemConstructBuilder<Problem78>(Problem78.class.getName()).build();
        for (List<Integer> liss : problem.subsets(new int[]{1, 2, 3})) {
            for (Integer i : liss) {
                System.out.print(i + "-");
            }
            System.out.println();
        }
    }
}
