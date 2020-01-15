package com.mdx.experiance.top.interview.tree;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.Stack;

/**
 * 实现描述：Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/22
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem98 {
    /**
     * 是否二叉查找树
     * 70 / 75 test cases passed.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        Integer val = Integer.MIN_VALUE;
        while (!stack.isEmpty() || tmp != null) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            // 当前值小于上次 非递增
            if (tmp.val <= val) {
                return false;
            }
            val = tmp.val;
            tmp = tmp.right;
        }

        return true;
    }

    public static void main(String[] args) {
        Problem98 problem = new ProblemConstructBuilder<Problem98>(Problem98.class.getName()).build();
        System.out.println(problem.isValidBST(TreeNode.array2TreeNode(new Integer[]{5, 1, 4, null, null, 3, 6})));
        System.out.println(problem.isValidBST(TreeNode.array2TreeNode(new Integer[]{2, 1, 3})));
        System.out.println(problem.isValidBST(TreeNode.array2TreeNode(new Integer[]{10, 5, 15, null, null, 6, 20})));
    }
}

