package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;
import com.mdx.experiance.struct.ListNode;

/**
 * 实现描述：
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/7/3
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        lists[0] = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }

    /**
     * 复用problem21的合并两个有序序列的代码
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        Problem23 problem23 = new ProblemConstructBuilder<Problem23>(Problem23.class.getName()).build();
        ListNode[] listNodes = new ListNode[]{ListNode.array2ListNode(new int[]{1, 4, 5}), ListNode.array2ListNode(new int[]{1, 3, 4}), ListNode.array2ListNode(new int[]{2, 6})};
        ListNode res = problem23.mergeKLists(listNodes);
        ListNode.output(res);
    }
}
