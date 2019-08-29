package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.Arrays;

/**
 * 实现描述：
 * Return any binary tree that matches the given preorder and postorder traversals.
 * <p>
 * Values in the traversals pre and post are distinct positive integers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/23
 */
@Info(status = StatusEnum.TRYING)
public class Problem889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || post.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(pre[0]);
        int pos = headPos(post[post.length - 1], pre);
        head.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, pos + 1), Arrays.copyOfRange(post, 0, pos));
        head.right = constructFromPrePost(Arrays.copyOfRange(pre, pos, pre.length), Arrays.copyOfRange(post, pos, post.length - 1));
        return head;
    }

    private int headPos(int num, int[] post) {
        for (int i = 0; i < post.length; i++) {
            if (post[i] == num) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Problem889 problem = new ProblemConstructBuilder<Problem889>(Problem889.class.getName()).build();
        TreeNode.levelOrder(problem.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
    }

}
