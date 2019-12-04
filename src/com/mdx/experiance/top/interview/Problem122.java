package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/4
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem122 {
    /**
     * 买卖股票：数组的每个数字代表股价，你可以多次交易，先买后卖，寻求最大利益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        int tmp = 0;

        for (int i = 1; i < prices.length; i++) {
            // 存储一次递增的结果
            if (prices[i] > prices[i - 1]) {
                tmp = prices[i] - min;
                continue;
            }
            //重置
            min = prices[i];
            maxProfit = maxProfit + tmp;
            tmp = 0;
        }
        if(tmp != 0) {
            maxProfit = maxProfit + tmp;
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        Problem122 problem = new ProblemConstructBuilder<Problem122>(Problem122.class.getName()).build();
        System.out.println(problem.maxProfit(new int[]{7, 1, 5, 6, 10, 4}));
        System.out.println(problem.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(problem.maxProfit(new int[]{7, 1, 5, 3, 2, 1}));
        System.out.println(problem.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }
}
