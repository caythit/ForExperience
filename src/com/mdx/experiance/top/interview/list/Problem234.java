package com.mdx.experiance.top.interview.list;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/19
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, t = head;
        Integer c = 0;
        while (t != null) {
            t = t.next;
            c++;
        }
        if (c == 1) {
            return true;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode right = reverse(c % 2 == 0 ? slow : slow.next);

        ListNode p = right, q = head;
        while (p != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    /**
     * 反转
     *
     * @param listNode
     * @return
     */
    private ListNode reverse(ListNode listNode) {
        ListNode p = listNode, q = listNode.next;
        while (q != null) {
            p.next = q.next;
            q.next = listNode;
            listNode = q;
            q = p.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
        Problem234 problem = new ProblemConstructBuilder<Problem234>(Problem234.class.getName()).build();
        System.out.println(problem.isPalindrome(ListNode.array2ListNode(new int[]{1, 2, 2, 1})));
    }
}
