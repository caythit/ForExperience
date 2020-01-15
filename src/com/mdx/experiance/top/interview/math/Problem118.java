package com.mdx.experiance.top.interview.math;

import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现描述：
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/4
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resAll = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> result = generate(resAll, i);
            resAll.add(result);
        }
        return resAll;
    }

    /**
     * @param resAll
     * @param numRows
     * @return
     */
    private List<Integer> generate(List<List<Integer>> resAll, int numRows) {
        List<Integer> result = new ArrayList<>();
        if (numRows == 0 || numRows == 1) {
            while (numRows-- >= 0) {
                result.add(1);
            }
            return result;
        }
        result.add(1);
        List<Integer> pre = resAll.get(numRows - 1);
        for (int i = 1; i < pre.size(); i++) {
            result.add(pre.get(i - 1) + pre.get(i));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        Problem118 problem = new ProblemConstructBuilder<Problem118>(Problem118.class.getName()).build();
        for (List<Integer> list : problem.generate(2)) {
            for (Integer l : list) {
                System.out.print(l + ",");
            }
            System.out.println();
        }

        for (List<Integer> list : problem.generate(5)) {
            for (Integer l : list) {
                System.out.print(l + ",");
            }
            System.out.println();
        }
    }
}
