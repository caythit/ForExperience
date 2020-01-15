package com.mdx.experiance.top.interview.backtrack;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.*;

/**
 * 实现描述：
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/2
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem40 {

    /**
     * 从给定数组中找出几个数字之和等于给定值
     * 说明：
     * （1）数组元素只能用一次
     * （2）不能返回重复的组合
     * （3）数组都是正数，但可能包含重复数字
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Integer pos = candidates.length - 1;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] < target) {
                continue;
            }
            pos = i;
            break;
        }
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> allResult = new ArrayList<>();
        combinationSum2(candidates, target, 0, pos, result, allResult);
        return allResult;
    }

    private void combinationSum2(int[] candidates, int target, int start, Integer len, List<Integer> result, List<List<Integer>> allResult) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            allResult.add(new ArrayList<>(result));
            return;
        }

        for (int i = start; i <= len; i++) {
            // 退出一层递归循环 也就是找到了满足条件的结果时 判断当前值与上一个值是否相等 去除重复
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            result.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, len, result, allResult);
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {
        Problem40 problem40 = new ProblemConstructBuilder<Problem40>(Problem40.class.getName()).build();
        List<List<Integer>> allResult = problem40.combinationSum2(new int[]{2, 5, 2, 1, 2, 5}, 5);
        for (List<Integer> result : allResult) {
            System.out.println("---");
            for (Integer r : result) {
                System.out.print(r + ",");
            }
            System.out.println();
        }
    }

}
