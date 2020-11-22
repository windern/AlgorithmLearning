package com.windern.algorithmlearning.mooc.linklist;

/**
 * 24. 两两交换链表中的节点
 *
 * @author windern
 * @date 2020/11/22 21:59
 **/
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode p = sentry;
        // while外只考虑p，其他node1、node2、next指针定义在while内
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            // 完成交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            // 前进
            p = node1;
        }

        return sentry.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ListNode listNode = ListNodeManager.create(array, array.length);
        ListNodeManager.print(listNode);
        ListNode result = swapPairs(listNode);
        ListNodeManager.print(result);
    }
}
