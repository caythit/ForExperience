package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 * <p>
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * <p>
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/18
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode firstOdd = head.next;
        ListNode q = firstOdd;

        while (q != null && q.next != null) {
            p.next = q.next;
            p = q.next;

            q.next = p.next;
            // 永远指向第一个偶数节点
            p.next = firstOdd;

            q = q.next;
        }

        return head;

    }

    public static void main(String[] args) {
        Problem328 problem = new ProblemConstructBuilder<Problem328>(Problem328.class.getName()).build();
        ListNode.output(problem.oddEvenList(ListNode.array2ListNode(new int[]{1, 2, 3, 4, 5, 6})));
        ListNode.output(problem.oddEvenList(ListNode.array2ListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}
