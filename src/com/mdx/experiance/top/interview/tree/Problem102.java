package com.mdx.experiance.top.interview.tree;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 实现描述：
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/9
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 拿出所有的treenode依次放入左右节点
            Queue<TreeNode> tmpQueue = new LinkedBlockingQueue<>();
            while (!queue.isEmpty()) {
                TreeNode head = queue.poll();
                level.add(head.val);

                if (head.left != null) {
                    tmpQueue.offer(head.left);
                }

                if (head.right != null) {
                    tmpQueue.offer(head.right);
                }
            }
            queue = tmpQueue;
            levelList.add(level);
        }
        return levelList;
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 拿出所有的treenode依次放入左右节点
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);

                if (head.left != null) {
                    queue.offer(head.left);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            levelList.add(level);
        }
        return levelList;
    }

    public static void main(String[] args) {
        Problem102 problem = new ProblemConstructBuilder<Problem102>(Problem102.class.getName()).build();
        TreeNode head = TreeNode.array2TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> levelList = problem.levelOrder(head);
        for (List<Integer> list : levelList) {
            for (Integer l : list) {
                System.out.print(l + ",");
            }
            System.out.println();
        }
    }


}
