package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。'
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/1
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem11 {

    /**
     * O(n^2)
     *
     * @param height
     * @return
     */
    public int maxAreaTemp(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    continue;
                }
                Integer value = Math.abs(j - i) * Math.min(height[i], height[j]);
                if (max < value) {
                    max = value;
                }
            }
        }
        return max;
    }

    /**
     * O(n)
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.abs(right - left) * Math.min(height[left], height[right]));
            if (height[right] > height[left]) {
                left++;
                continue;
            }
            right--;

        }

        return max;
    }

    public static void main(String[] args) {
        Problem11 problem11 = new ProblemConstructBuilder<Problem11>(Problem11.class.getName()).build();
        System.out.println(problem11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
