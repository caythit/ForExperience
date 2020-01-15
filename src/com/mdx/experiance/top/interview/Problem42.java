package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

/**
 * 实现描述：
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/4
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem42 {
    /**
     * 数组每个元素代表高度，问能装多少水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        Integer res = 0, minIndex = -1;
        while (left < right) {
            if (height[left] > height[right]) {
                minIndex = right;
                right--;

                while (left < right && height[right] < height[minIndex]) {
                    res = res + (height[minIndex] - height[right]);
                    right--;
                }
            } else {
                minIndex = left;
                left++;
                while (left < right && height[left] < height[minIndex]) {
                    res = res + (height[minIndex] - height[left]);
                    left++;
                }
            }
        }
        return res;
    }

    /**
     * 数组每个元素代表高度，问最多能装多少水
     *
     * @param height
     * @return
     */
    public int trapDP(int[] height) {
        int size = height.length;
        int[] leftMaxDP = new int[size];
        int[] rightMaxDP = new int[size];

        leftMaxDP[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMaxDP[i] = Math.max(leftMaxDP[i - 1], height[i]);
        }
        rightMaxDP[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMaxDP[i] = Math.max(rightMaxDP[i + 1], height[i]);
        }

        int res = 0;
        for(int i =0;i<size;i++) {
            res += Math.min(leftMaxDP[i], rightMaxDP[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem42 problem = new ProblemConstructBuilder<Problem42>(Problem42.class.getName()).build();
        System.out.println(problem.trapDP(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
