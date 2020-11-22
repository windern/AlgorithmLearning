package com.windern.algorithmlearning.mooc.linklist;

/**
 * 206. 反转链表
 *
 * @author windern
 * @date 2020/11/22 20:57
 **/
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            // 交换
            cur.next = pre;

            // 往前进下一步
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        ListNode after = reverseList2(next);

        ListNode loop = after;
        while (loop.next != null) {
            loop = loop.next;
        }
        loop.next = cur;

        return after;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeManager.create(5);
        ListNodeManager.print(listNode);
        ListNode result = reverseList2(listNode);
        ListNodeManager.print(result);
    }
}
