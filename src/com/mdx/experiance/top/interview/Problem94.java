package com.mdx.experiance.top.interview;

import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现描述：
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/15
 */
public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode tmp = root;
        while (tmp.left != null) {
            treeNodeStack.push(tmp.left);
            tmp = tmp.left;
        }

        return null;
    }

    public static void main(String[] args) {
        Problem94 problem = new ProblemConstructBuilder<Problem94>(Problem94.class.getName()).build();
        TreeNode.inOrder(TreeNode.array2TreeNode(new Integer[]{1, null, 2, null, null, 3}));
        for (Integer i : problem.inorderTraversal(TreeNode.array2TreeNode(new Integer[]{1, null, 2, null, null, 3}))) {
            System.out.println(i);
        }
    }
}
