package com.mdx.experiance.top.interview.structure;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.*;

/**
 * 实现描述：Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/23
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        String res = "[";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (allElementNull(queue)) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    res += "null,";
                } else {
                    res += cur.val + ",";
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        return res.substring(0, res.lastIndexOf(",")) + "]";
    }

    private boolean allElementNull(Queue<TreeNode> queue) {
        Queue<TreeNode> tmp = new LinkedList<>(queue);
        tmp.removeIf(x -> x == null);
        return tmp.isEmpty();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str = data.substring(1, data.indexOf("]"));
        if (str.isEmpty()) {
            return null;
        }
        List<String> arrays = Arrays.asList(str.split(","));

        TreeNode root = new TreeNode(Integer.valueOf(arrays.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int t = 1;
        out:
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                if (t >= arrays.size()) {
                    break out;
                }
                TreeNode cur = queue.poll();
                cur.left = "null".equals(arrays.get(t)) ? null : new TreeNode(Integer.valueOf(arrays.get(t)));
                t++;
                cur.right = "null".equals(arrays.get(t)) ? null : new TreeNode(Integer.valueOf(arrays.get(t)));
                t++;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

            }
        }
        return root;
    }

    public static void main(String[] args) {
        Problem297 problem = new ProblemConstructBuilder<Problem297>(Problem297.class.getName()).build();
        TreeNode treeNode = problem.deserialize("[5,2,3,null,null,2,4,3,1]");
        System.out.println(problem.serialize(treeNode));

    }
}
