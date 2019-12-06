package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/5
 */
@Info(status = StatusEnum.WRONG_ANSWER)
public class Problem148 {

    class Pair<K, V> {
        K left;
        V right;

        public Pair(K left, V right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 链表排序
     * 时间复杂度 O(nlogN) 空间复杂度 O(1)
     * 总共16个case，通过了15个，有一个超时
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode resHead = new ListNode(-1);
        ListNode p = resHead;

        while (head != null) {
            // 只剩下最后一个元素时 直接返回
            if (head.next == null) {
                p.next = head;
                break;
            }
            // 否则移除最小元素
            Pair<Integer, ListNode> minNodePair = removeMinNode(head);
            p.next = new ListNode(minNodePair.left);
            head = minNodePair.right;
            p = p.next;
        }
        return resHead.next;
    }

    /**
     * 移除链表的最小节点 并返回它
     *
     * @param head
     * @return
     */
    private Pair<Integer, ListNode> removeMinNode(ListNode head) {
        // 前后节点
        ListNode p = head;
        ListNode q = head.next;

        ListNode minNode = head;
        // 指向最小节点的前一个
        ListNode minPreNode = head;

        while (q != null) {
            if (minNode.val > q.val) {
                minPreNode = p;
                minNode = q;
            }
            p = q;
            q = q.next;
        }
        // 最小节点在头部
        if (minNode == head) {
            head = head.next;
            return new Pair<>(minNode.val, head);
        }
        minPreNode.next = minNode.next;
        return new Pair<>(minNode.val, head);
    }

    public static void main(String[] args) {
        Problem148 problem = new ProblemConstructBuilder<Problem148>(Problem148.class.getName()).build();
        ListNode.output(problem.sortList(ListNode.array2ListNode(new int[]{4, 2, 1, 3})));
        ListNode.output(problem.sortList(ListNode.array2ListNode(new int[]{-1, 5, 3, 4, 0})));

//        ListNode head = ListNode.array2ListNode(new int[]{4, 2, 1, 3});
//        while (head != null) {
//            problem.removeMinNode(head);
//        }


    }
}
