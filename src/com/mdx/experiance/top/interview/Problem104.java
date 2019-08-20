package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

/**
 * 实现描述：
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/20
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        Problem104 problem = new ProblemConstructBuilder<Problem104>(Problem104.class.getName()).build();
        System.out.println(problem.maxDepth(TreeNode.array2TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
