package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 实现描述：
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/8
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem215 {

    public int findKthLargest(int[] nums, int k) {
//        return findBySwitchSort(nums, k);
        return findByPriorityQueue(nums, k);
    }

    /**
     * 最大/小堆实现
     * O（n*logk）
     *
     * @param nums
     * @param k
     * @return
     */
    private int findByPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
                continue;
            }
            int head = priorityQueue.peek();
            if (head < nums[i]) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }

    /**
     * 交换排序实现
     * O（k*n）
     *
     * @param nums
     * @param k
     * @return
     */
    private int findBySwitchSort(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums[k - 1];
    }

    public static void main(String[] args) {
        Problem215 problem = new ProblemConstructBuilder<Problem215>(Problem215.class.getName()).build();
        System.out.println(problem.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(problem.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
