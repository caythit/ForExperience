package com.mdx.experiance.struct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现描述：
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/9
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode array2TreeNode(Integer[] arrays) {
        return list2TreeNode(Arrays.asList(arrays));
    }

    public static TreeNode list2TreeNode(List<Integer> list) {
        return list2TreeNode(list, 0);
    }

    private static TreeNode list2TreeNode(List<Integer> list, int start) {
        if (list.get(start) == null) {
            return null;
        }
        TreeNode cur = new TreeNode(list.get(start));
        Integer l = 2 * start + 1;
        Integer r = 2 * start + 2;

        if (l > list.size() - 1) {
            cur.left = null;
        } else {
            cur.left = list2TreeNode(list, l);
        }

        if (r > list.size() - 1) {
            cur.right = null;
        } else {
            cur.right = list2TreeNode(list, r);
        }
        return cur;
    }

    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }

    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void levelOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(treeNode);
        Integer level = 1;

        while (!queue.isEmpty()) {

            System.out.println("level=" + level++);
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                System.out.print(t.val + "->");

                if (t.left != null) {
                    queue.add(t.left);
                }

                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{1, null, 2, null, null, 3, 4};
        TreeNode treeNode = TreeNode.array2TreeNode(arrays);
        preOrder(treeNode);
        System.out.println("------------------");
        inOrder(treeNode);
        System.out.println("------------------");
        postOrder(treeNode);
        System.out.println("------------------");
        levelOrder(treeNode);
    }
}
