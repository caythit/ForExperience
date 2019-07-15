package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

/**
 * 实现描述：
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * But the following [1,2,2,null,3,null,3] is not:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/15
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * @param left
     * @param right
     * @return
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 空！=非空
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem101 problem = new ProblemConstructBuilder<Problem101>(Problem101.class.getName()).build();
        System.out.println(problem.isSymmetric(TreeNode.array2TreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(problem.isSymmetric(TreeNode.array2TreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }
}
