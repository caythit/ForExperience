package com.mdx.experiance.top.interview.list;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * <p>
 * Given n will always be valid.
 * <p>
 * Follow up:
 * <p>
 * Could you do this in one pass?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        while (n-- > 0) {
            q = q.next;
        }

        while (p != null && q != null && p.next != null && q.next != null) {
            p = p.next;
            q = q.next;
        }

        // 没有发生移动 表示移除链表头部
        if (p == head && q == null) {
            return head.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        } else {
            return null;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem19 problem19 = new ProblemConstructBuilder<Problem19>(Problem19.class.getName()).build();
//        ListNode.output(
//                problem19.removeNthFromEnd(
//                        ListNode.array2ListNode(new int[]{1, 2, 3, 4, 5}), 2));


        ListNode.output(
                problem19.removeNthFromEnd(
                        ListNode.array2ListNode(new int[]{1, 2}), 2));
        ListNode.output(
                problem19.removeNthFromEnd(
                        ListNode.array2ListNode(new int[]{1, 2}), 1));
    }
}
