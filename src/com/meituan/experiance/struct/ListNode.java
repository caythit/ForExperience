package com.meituan.experiance.struct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现描述：链表结构
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/6/10
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode array2ListNode(int[] arrays) {
        return list2ListNode(Arrays.stream(arrays).boxed().collect(Collectors.toList()));
    }

    public static ListNode list2ListNode(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode tmp = head;
        for (int i = 1; i < list.size(); i++) {
            tmp.next = new ListNode(list.get(i));
            tmp = tmp.next;
        }
        return head;
    }

    public static void output(ListNode listNode) {
        StringBuilder sb = new StringBuilder("");
        while (listNode != null) {
            sb.append(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf("->")));
    }

}
