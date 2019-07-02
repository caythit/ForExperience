package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/2
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergedList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                mergedList.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            mergedList = mergedList.next;

        }
        if (l1 != null) {
            mergedList.next = l1;
        }
        if (l2 != null) {
            mergedList.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Problem21 problem21 = new ProblemConstructBuilder<Problem21>(Problem21.class.getName()).build();
        ListNode res = problem21.mergeTwoLists(
                ListNode.array2ListNode(new int[]{1, 2, 4}),
                ListNode.array2ListNode(new int[]{1, 3, 4}));
        ListNode.output(res);
    }
}
