package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.Problem18;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/29
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem454 {

    /**
     * 超时，剩下两个case没有通过
     * 时间复杂度：O(n^2) + O(n^2) + O(n^4)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {


        int[] sumAB = combineTwoArraySum(A, B);
        int[] sumCD = combineTwoArraySum(C, D);

        Integer res = 0;
        for (int i = 0; i < sumAB.length; i++) {
            for (int j = 0; j < sumCD.length; j++) {
                if (sumAB[i] + sumCD[j] == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 用map来做，类似twosum的解决方法
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCountV2(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> minusMap = new HashMap<>();
        Integer res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                Integer sum = A[i] + B[j];
                minusMap.put(sum, minusMap.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                Integer sum = C[i] + D[j];
                if (minusMap.containsKey(sum * -1)) {
                    res += minusMap.get(sum * -1);
                }
            }
        }
        return res;
    }

    private int[] combineTwoArraySum(int[] num1, int[] num2) {
        int[] sum = new int[num1.length * num2.length];

        Integer st = 0;
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                sum[st++] = num1[i] + num2[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem454 Problem454 = new ProblemConstructBuilder<Problem454>(Problem454.class.getName()).build();
        Problem454.fourSumCountV2(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
    }

}
