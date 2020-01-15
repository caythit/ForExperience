package com.mdx.experiance.top.interview.list;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/12/9
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem160 {

    /**
     * 返回两个链表的交集点
     * O(n) time and use only O(1) space
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = listLen(headA);
        int lenB = listLen(headB);
        if (lenA == 0 || lenB == 0) {
            return null;
        }

        int skip = Math.abs(lenA - lenB);
        ListNode p = headA, q = headB;
        if (skip != 0) {
            if (lenA > lenB) {
                while (skip-- > 0) {
                    p = p.next;
                }

            } else if (lenA < lenB) {
                while (skip-- > 0) {
                    q = q.next;
                }
            }
        }

        while (p != null && q != null) {
            if (p.val == q.val) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    private int listLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


    public static void main(String[] args) {
        Problem160 problem = new ProblemConstructBuilder<Problem160>(Problem160.class.getName()).build();
        System.out.println(problem.getIntersectionNode(ListNode.array2ListNode(new int[]{0, 9, 1, 2, 4}), ListNode.array2ListNode(new int[]{3, 2, 4})).val);
    }
}
