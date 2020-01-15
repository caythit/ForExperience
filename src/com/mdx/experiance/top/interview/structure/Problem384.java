package com.mdx.experiance.top.interview.structure;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 实现描述：Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/21
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem384 {

    private int[] nums;
    static Random random = new Random();
    List<List<Integer>> perm;

    public Problem384(int[] nums) {
        this.nums = nums;
        perm = permute();

    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        List<Integer> res = perm.get(random.nextInt(perm.size()));
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<List<Integer>> permute() {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> resAll = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        permute(nums.length, res, resAll, isUsed);
        return resAll;
    }

    private void permute(int length, List<Integer> res, List<List<Integer>> resAll, boolean[] isUsed) {
        if (res.size() == length) {
            resAll.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (isUsed[i] == false) {
                res.add(nums[i]);
                isUsed[i] = true;
                permute(length, res, resAll, isUsed);
                res.remove(res.size() - 1);
                isUsed[i] = false;
            }

        }

    }

    public static void main(String[] args) {
        Problem384 problem = new Problem384(new int[]{1, 2, 3});
        problem.shuffle();
        problem.reset();
        problem.shuffle();
    }
}
