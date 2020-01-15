package com.mdx.experiance.top.interview.list;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/10
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;

        ListNode result = null;
        ListNode tmp = null;
        int flag = 0;
        while (tmp1 != null && tmp2 != null) {
            int sum = tmp1.val + tmp2.val + flag;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }

            if (result == null) {
                result = new ListNode(sum % 10);
                tmp = result;
            } else {
                tmp.next = new ListNode(sum % 10);
                tmp = tmp.next;
            }

            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        while (tmp1 != null) {
            int sum = tmp1.val + flag;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }

        while (tmp2 != null) {
            int sum = tmp2.val + flag;
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }

        if(flag == 1) {
            tmp.next = new ListNode(flag);
        }

        return result;
    }


    public static void main(String[] args) {
        Problem2 problem2 = new ProblemConstructBuilder<Problem2>(Problem2.class.getName()).build();

        ListNode l1 = ListNode.array2ListNode(new int[]{9,8});
        ListNode l2 = ListNode.array2ListNode(new int[]{1});
        ListNode result = problem2.addTwoNumbers(l1, l2);
        ListNode.output(result);

    }
}
