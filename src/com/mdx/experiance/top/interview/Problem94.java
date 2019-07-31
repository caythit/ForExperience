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
        while (!treeNodeStack.empty() || tmp != null) {
            while (tmp != null) {
                treeNodeStack.push(tmp);
                tmp = tmp.left;
            }
            if (!treeNodeStack.empty()) {
                tmp = treeNodeStack.pop();
                res.add(tmp.val);
                tmp = tmp.right;
            }

        }
        return res;
    }

    public List<Integer> inorderTraversalV2(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode tmp = root;
        treeNodeStack.push(tmp);
        while (!treeNodeStack.empty()) {
            if (tmp.right != null) {
                treeNodeStack.push(tmp.right);
            }

            if (tmp.left != null) {
                treeNodeStack.push(tmp.left);
            }
            tmp = treeNodeStack.pop();
            res.add(tmp.val);

        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode tmp = root;
        treeNodeStack.push(tmp);
        while (!treeNodeStack.empty()) {
            tmp = treeNodeStack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                treeNodeStack.push(tmp.right);
            }

            if (tmp.left != null) {
                treeNodeStack.push(tmp.left);
            }

        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode tmp = root;
        treeNodeStack.push(tmp);
        while (!treeNodeStack.empty()) {
            tmp = treeNodeStack.pop();
            res.add(tmp.val);

            if (tmp.left != null) {
                treeNodeStack.push(tmp.left);
            }

            if (tmp.right != null) {
                treeNodeStack.push(tmp.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem94 problem = new ProblemConstructBuilder<Problem94>(Problem94.class.getName()).build();
//        TreeNode.inOrder(TreeNode.array2TreeNode(new Integer[]{1, null, 2, null, null, 3}));

        for (Integer i : problem.preorderTraversal(TreeNode.array2TreeNode(new Integer[]{1, 4, 2, 7, 5, 3}))) {
            System.out.print(i + "->");
        }
        System.out.println();

        for (Integer i : problem.inorderTraversalV2(TreeNode.array2TreeNode(new Integer[]{1, 4, 2, 7, 5, 3}))) {
            System.out.print(i + "->");
        }
        System.out.println();

        for (Integer i : problem.postorderTraversal(TreeNode.array2TreeNode(new Integer[]{1, 4, 2, 7, 5, 3}))) {
            System.out.print(i + "->");
        }
    }
}
