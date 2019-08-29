package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 实现描述：
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/28
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);

        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (!stack.isEmpty() || tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            if (!stack.isEmpty()) {
                tmp = stack.pop();
                if (pq.size() < k) {
                    pq.offer(tmp.val);
                }
                tmp = tmp.right;
            }
        }
        Integer[] res = new Integer[k];
        pq.toArray(res);
        return res[res.length - 1];
    }

    public static void main(String[] args) {
        Problem230 problem = new ProblemConstructBuilder<Problem230>(Problem230.class.getName()).build();
        problem.kthSmallest(TreeNode.array2TreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3);
    }

}
