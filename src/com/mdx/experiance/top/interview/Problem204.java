package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/16
 */
@Info(status = StatusEnum.TRYING)
public class Problem204 {
    public int countPrimes(int n) {
        boolean[] isPrime = initArrays(n);
        Integer cn = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i) == true) {
                cn++;
            }
        }
        return cn;

    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            for (int j = i * i; j < num; j++) {

            }
        }
        return false;
    }

    private boolean[] initArrays(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = false;
        }
        return isPrime;
    }

    private Map<Integer, Integer> initTenPrimiMap() {
        Map<Integer, Integer> map = new HashMap<>(8);
        map.put(3, 1);
        map.put(4, 2);
        map.put(5, 2);
        map.put(6, 3);
        map.put(7, 3);
        map.put(8, 4);
        map.put(9, 4);
        map.put(10, 4);
        return map;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(4.0));
        Problem204 problem = new ProblemConstructBuilder<Problem204>(Problem204.class.getName()).build();
//        System.out.println(problem.countPrimes(10));
//        System.out.println(problem.countPrimes(11));
//        System.out.println(problem.countPrimes(13));
//        System.out.println(problem.countPrimes(100));
        System.out.println(problem.countPrimes(10000));
    }
}
