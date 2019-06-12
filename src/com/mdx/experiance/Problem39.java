package com.mdx.experiance;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.annotation.Mark;
import com.mdx.experiance.enums.StatusEnum;

import java.util.*;

/**
 * 实现描述：
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/1
 */
@Info(status = StatusEnum.ACCEPTTED)
@Mark
public class Problem39 {

    /**
     * 从无重复数字的给定数组中找出几个数字之和等于给定值
     * 说明：
     * （1）数组元素可以重复利用无限次
     * （2）不能返回重复的组合
     * （3）数组都是正数
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> allResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        combinationSum(0, candidates, target, result, allResult);

        return allResult;
    }

    public void combinationSum(int start, int[] candidates, int target, List<Integer> result, List<List<Integer>> allResult) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            allResult.add(new ArrayList<>(result));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            result.add(candidates[i]);
            combinationSum(i, candidates, target - candidates[i], result, allResult);
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {
        Problem39 problem39 = new ProblemConstructBuilder<Problem39>(Problem39.class.getName()).build();
        for (List<Integer> result : problem39.combinationSum(new int[]{2, 3, 6, 7}, 7)) {
            System.out.println("---");
            for (Integer r : result) {
                System.out.print(r + ",");
            }
            System.out.println();
        }


    }
}
