package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/8
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem141 {
    /**
     * 判断链表是否存在环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;

            if (q == p) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem141 problem = new ProblemConstructBuilder<Problem141>(Problem141.class.getName()).build();

        ListNode listNode = ListNode.array2ListNode(new int[]{1, 2, 1, 2, 1, 2, 1, 2});
        System.out.println(problem.hasCycle(listNode));

        ListNode listNode1 = ListNode.array2ListNode(new int[]{3, 2, 0, -4, 0, -4});
        System.out.println(problem.hasCycle(listNode1));

    }
}
