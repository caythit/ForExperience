package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 实现描述：Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/16
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem236 {

    /**
     * 最小祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val) {
            return p;
        }
        if (q.val == root.val) {
            return q;
        }

        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmpQueue = new LinkedBlockingQueue<>(queue);
            for (int i = 0; i < tmpQueue.size(); i++) {
                TreeNode cur = queue.poll();
                TreeNode curLeft = cur.left;
                TreeNode curRight = cur.right;

                if (curLeft != null) {
                    queue.offer(curLeft);
                    parentMap.put(curLeft.val, cur);
                }
                if (curRight != null) {
                    queue.offer(curRight);
                    parentMap.put(curRight.val, cur);
                }
            }
        }

        List<Integer> pAncestors = new ArrayList<>();
        while (p != null) {
            pAncestors.add(p.val);
            p = parentMap.get(p.val);
        }

        while (true) {
            if (!pAncestors.contains(q.val)) {
                q = parentMap.get(q.val);
            } else {
                return q;
            }
        }
    }

    public static void main(String[] args) {
        Problem236 problem = new ProblemConstructBuilder<Problem236>(Problem236.class.getName()).build();
        System.out.println(problem.lowestCommonAncestor(
                TreeNode.array2TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}),
                new TreeNode(5), new TreeNode(1)).val);
    }
}
