package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/17
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next;
        while (q != null) {
            p.next = q.next;
            q.next = head;
            head = q;
            q = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem206 problem = new ProblemConstructBuilder<Problem206>(Problem206.class.getName()).build();
        ListNode.output(problem.reverseList(ListNode.array2ListNode(new int[]{1, 2, 3, 4, 5})));
    }
}
