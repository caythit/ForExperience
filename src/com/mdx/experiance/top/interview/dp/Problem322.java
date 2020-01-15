package com.mdx.experiance.top.interview.dp;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实现描述：You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem322 {
    /**
     * 寻找最小的硬币个数之和等于给定值
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        List<Integer> coinList = new ArrayList<>();
        // 去除比amount大的coin
        for (int coin : coins) {
            if (coin <= amount) {
                coinList.add(coin);
            }
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        for (int coin : coinList) {
            dp[coin] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[coins[j]] + dp[i - coins[j]]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Problem322 problem = new ProblemConstructBuilder<Problem322>(Problem322.class.getName()).build();
        System.out.println(problem.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(problem.coinChange(new int[]{2}, 3));
        System.out.println(problem.coinChange(new int[]{1}, 0));
        System.out.println(problem.coinChange(new int[]{1, 2147483647}, 2));
        System.out.println(problem.coinChange(new int[]{185, 429, 111, 150, 414, 203, 418}, 8197));
    }
}
