package com.mdx.experiance.top.interview.math;

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
@Info(status = StatusEnum.ACCEPTTED)
public class Problem204 {

    /**
     * 空间换时间
     * 埃拉托色筛选法
     * 一个质数总是可以分解成若干个质数的乘积，那么如果把质数（最初只知道2是质数）的倍数都去掉，那么剩下的就是质数了
     *
     * @param n
     * @return
     */
    private int countPrimesNew(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n <= 10) {
            Map<Integer, Integer> tenPrimeMap = initTenPrimeMap();
            return tenPrimeMap.get(n);
        }

        // 不包含自身
        if (n % 2 == 1) {
            n = n - 2;
        }
        //转成奇数
        if (n % 2 == 0) {
            n = n - 1;
        }
        int cn = 0;

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true) {
                for (int k = 2; k <= n / i; k++) {
                    isPrime[k * i] = false;
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            if (isPrime[i] == true) {
                cn++;
            }
        }


        return cn;
    }

    /**
     * 非负数N包含的素数个数
     * 常规方式，O(n/2) * O(sqrt(n)) 时间复杂度
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n <= 10) {
            Map<Integer, Integer> tenPrimeMap = initTenPrimeMap();
            return tenPrimeMap.get(n);
        }
        int cn = 4;
        // 不包含自身
        if (n % 2 == 1) {
            n = n - 2;
        }
        //转成奇数
        if (n % 2 == 0) {
            n = n - 1;
        }

        while (n > 10) {
            if (n % 2 == 0 && n % 3 == 0 && n % 5 == 0 && n % 7 == 0) {
                continue;
            }
            if (isPrime(n)) {
                cn += 1;
            }
            n -= 2;
        }
        return cn;
    }

    private boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> initTenPrimeMap() {
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
        Problem204 problem = new ProblemConstructBuilder<Problem204>(Problem204.class.getName()).build();
//        System.out.println(problem.countPrimes(10));
//        System.out.println(problem.countPrimes(11));
//        System.out.println(problem.countPrimes(13));
//        System.out.println(problem.countPrimes(100));
//        System.out.println(problem.countPrimes(1000));
        long start = System.currentTimeMillis();
        System.out.println(problem.countPrimes(1500000) + ", times:" + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        System.out.println(problem.countPrimesNew(1500000) + ", times:" + (System.currentTimeMillis() - start1));
        System.out.println(problem.countPrimesNew(100) + ", times:" + (System.currentTimeMillis() - start1));
        System.out.println(problem.countPrimesNew(10000) + ", times:" + (System.currentTimeMillis() - start1));
    }


}
