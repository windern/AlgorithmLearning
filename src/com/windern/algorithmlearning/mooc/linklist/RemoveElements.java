package com.windern.algorithmlearning.mooc.linklist;

/**
 * 203. 移除链表元素
 *
 * @author windern
 * @date 2020/11/22 21:43
 **/
public class RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode cur = sentry;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return sentry.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = ListNodeManager.create(array, array.length);
        ListNodeManager.print(listNode);
        ListNode result = removeElements(listNode, 6);
        ListNodeManager.print(result);
    }
}
