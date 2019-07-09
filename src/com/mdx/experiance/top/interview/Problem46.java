package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/4
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allResultList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        permute(nums, isUsed, resultList, allResultList);
        return allResultList;

    }

    private void permute(int[] nums, boolean[] isUsed, List<Integer> resultList, List<List<Integer>> allResultList) {
        if (resultList.size() == nums.length) {
            allResultList.add(new ArrayList<>(resultList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == false) {
                resultList.add(nums[i]);
                isUsed[i] = true;
                permute(nums, isUsed, resultList, allResultList);
                resultList.remove(resultList.size() - 1);
                isUsed[i] = false;
            }

        }

    }

    public static void main(String[] args) {
        Problem46 problem = new ProblemConstructBuilder<Problem46>(Problem46.class.getName()).build();
        for (List<Integer> num : problem.permute(new int[]{1, 2, 3})) {
            for (int n : num) {
                System.out.println(n);
            }
        }
    }
}
