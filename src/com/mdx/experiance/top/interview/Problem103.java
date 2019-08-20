package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.*;

/**
 * 实现描述：
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/20
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) {
            return allResult;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> tmpQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                result.add(tmp.val);
                if (tmp.left != null) {
                    tmpQueue.add(tmp.left);
                }
                if (tmp.right != null) {
                    tmpQueue.add(tmp.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(result);
            }
            queue = tmpQueue;
            allResult.add(result);
            level++;
        }
        return allResult;
    }

    public static void main(String[] args) {
        Problem103 problem = new ProblemConstructBuilder<Problem103>(Problem103.class.getName()).build();
        TreeNode.preOrder(TreeNode.array2TreeNode(new Integer[]{1, 2, 3, 4, null, null, 5}));
        for (List<Integer> integerList : problem.zigzagLevelOrder(TreeNode.array2TreeNode(new Integer[]{1, 2, 3, 4, null, null, 5}))) {
            for (Integer integer : integerList) {
                System.out.print(integer + "->");
            }
            System.out.println();
        }
    }
}
