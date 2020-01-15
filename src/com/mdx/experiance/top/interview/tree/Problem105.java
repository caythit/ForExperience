package com.mdx.experiance.top.interview.tree;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.Arrays;

/**
 * 实现描述：Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
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
 * @since 2019/8/20
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        int pos = headPos(preorder[0], inorder);
        head.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));
        head.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));
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
        Problem105 problem = new ProblemConstructBuilder<Problem105>(Problem105.class.getName()).build();
        TreeNode.preOrder(problem.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
