package com.windern.algorithmlearning.mooc.linklist;

/**
 * @author windern
 * @date 2020/11/22 20:58
 **/
public class ListNodeManager {

    public static ListNode create(int n) {
        ListNode head = new ListNode(0);

        ListNode cur = head;
        for (int i = 1; i <= n; i++) {
            ListNode item = new ListNode(i);
            cur.next = item;

            cur = cur.next;
        }

        return head.next;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + "->");

            cur = cur.next;
        }
        System.out.print("NULL\n");
    }
}
