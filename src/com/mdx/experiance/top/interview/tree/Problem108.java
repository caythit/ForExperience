package com.mdx.experiance.top.interview.tree;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

/**
 * 实现描述：
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem108 {
    /**
     * 有序数组转换成BST
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[len / 2]);
        head.left = generateBST(0, len / 2 - 1, nums);
        head.right = generateBST(len / 2 + 1, len, nums);
        return head;
    }

    private TreeNode generateBST(int st, int et, int[] nums) {
        if (st > et || st >= nums.length) {
            return null;
        }
        int mid = (st + et) / 2;

        TreeNode head = new TreeNode(nums[mid]);
        head.left = generateBST(st, mid - 1, nums);
        head.right = generateBST(mid + 1, et, nums);
        return head;
    }

    public static void main(String[] args) {
        Problem108 problem = new ProblemConstructBuilder<Problem108>(Problem108.class.getName()).build();
        TreeNode.inOrder(problem.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        TreeNode.preOrder(problem.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
