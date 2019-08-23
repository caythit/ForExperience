package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.Arrays;

/**
 * 实现描述：
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/23
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(postorder[postorder.length - 1]);
        int pos = headPos(postorder[postorder.length - 1], inorder);
        head.left = buildTree(Arrays.copyOfRange(inorder, 0, pos), Arrays.copyOfRange(postorder, 0, pos));
        head.right = buildTree(Arrays.copyOfRange(inorder, pos + 1, inorder.length), Arrays.copyOfRange(postorder, pos, postorder.length - 1));
        return head;
    }

    private int headPos(int num, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem106 problem = new ProblemConstructBuilder<Problem106>(Problem106.class.getName()).build();

//        System.out.println(Arrays.copyOfRange(new int[]{9, 3, 15, 20, 7}, 0, 1));
        TreeNode.levelOrder(problem.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
