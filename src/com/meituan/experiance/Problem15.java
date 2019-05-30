package com.meituan.experiance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现描述：
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/23
 */
public class Problem15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> positiveList = new ArrayList<>();
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();

        // 限制 0最多出现3次、正负相同的数最多允许两个
        int zeroLimit = 3;
        Map<Integer, Integer> numLimit = new HashMap<>();
        for (Integer num : nums) {
            if (num == 0 && zeroLimit-- > 0) {
                zeroList.add(num);
            } else if (numLimit.get(num) == null || numLimit.get(num) < 2) {
                if(num < 0) {
                    negativeList.add(num);
                } else {
                    positiveList.add(num);
                }
            }
            numLimit.put(num, !numLimit.containsKey(num) ? 1 : numLimit.get(num) + 1);
        }

        // 含有0 特殊处理
        if (zeroList.size() != 0) {

            // 三0组合 只取一次
            if (zeroList.size() >= 3) {
                List<Integer> result = new ArrayList<>();
                result.add(0);
                result.add(0);
                result.add(0);
                resultList.add(result);
            }

            List<Integer> tmp = new ArrayList<>();
            // 循环一次 获取一正一负组合, 去除重复
            for (Integer positive : positiveList) {
                if (negativeList.contains(-1 * positive) && !tmp.contains(positive)) {
                    List<Integer> result = new ArrayList<>();
                    result.add(-1 * positive);
                    result.add(0);
                    result.add(positive);
                    resultList.add(result);
                    tmp.add(positive);
                }
            }
        }

        List<Integer> tmp = new ArrayList<>();
        // 两正一负、两负一正组合
        for (Integer pos : positiveList) {
            if (!tmp.contains(pos)) {
                List<List<Integer>> twoNegOnePosList = twoSum(negativeList, -1 * pos);
                if (twoNegOnePosList.size() != 0) {
                    for (List<Integer> twoNegOnePos : twoNegOnePosList) {
                        twoNegOnePos.add(pos);
                    }
                    resultList.addAll(twoNegOnePosList);
                }
                tmp.add(pos);
            }

        }

        for (Integer neg : negativeList) {
            if (!tmp.contains(neg)) {
                List<List<Integer>> twoPosOneNegList = twoSum(positiveList, -1 * neg);
                if (twoPosOneNegList.size() != 0) {
                    for (List<Integer> twoPosOneNeg : twoPosOneNegList) {
                        twoPosOneNeg.add(neg);
                    }
                    resultList.addAll(twoPosOneNegList);
                }
                tmp.add(neg);
            }
        }
        return resultList;
    }

    /**
     * 找出所有的两个数字组合 使其之和等于给定的数字
     *
     * @param arrays
     * @param target
     * @return
     */
    private List<List<Integer>> twoSum(List<Integer> arrays, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        // key为相减的结果 value为数组下标
        Map<Integer, Integer> minusMap = new HashMap<>();
        for (int i = 0; i < arrays.size(); i++) {
            int minus = target - arrays.get(i);
            if(!minusMap.containsKey(minus)) {
                minusMap.put(minus, i);
            }
        }

        // 已经用过的数字
        List<Integer> usedValue = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            // 小于下标避免 且没有
            if (minusMap.get(arrays.get(i)) != null && !usedValue.contains(arrays.get(i)) && i != minusMap.get(arrays.get(i))) {
                List<Integer> result = new ArrayList<>();
                result.add(arrays.get(i));
                result.add(target - arrays.get(i));
                resultList.add(result);

                usedValue.add(arrays.get(i));
                usedValue.add(target - arrays.get(i));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Problem15 problem15 = new ProblemConstructBuilder<Problem15>(Problem15.class.getName()).build();
        List<List<Integer>> result = problem15.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
        result.forEach(r -> r.forEach(x -> System.out.println(x)));

    }
}
