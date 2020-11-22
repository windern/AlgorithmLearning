package com.windern.algorithmlearning.mooc.linklist;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author windern
 * @date 2020/11/22 22:28
 **/
public class RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟投节点
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        // p要删除的元素的上一个，q最后指向null，p-q的距离固定n+1
        ListNode p = sentry;
        ListNode q = sentry;
        // 已2为例来算，看是运行多少次
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return sentry.next;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ListNode listNode = ListNodeManager.create(array, array.length);
        ListNodeManager.print(listNode);
        ListNode result = removeNthFromEnd(listNode, 2);
        ListNodeManager.print(result);
    }
}
