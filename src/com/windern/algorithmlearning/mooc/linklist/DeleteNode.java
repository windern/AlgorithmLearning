package com.windern.algorithmlearning.mooc.linklist;

/**
 * 237. 删除链表中的节点
 *
 * @author windern
 * @date 2020/11/22 22:15
 **/
public class DeleteNode {

    public static void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
        }

        // node.next不为空
        ListNode nextNext = node.next.next;
        // 更新值，删除next元素
        node.val = node.next.val;
        node.next = nextNext;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        ListNode listNode = ListNodeManager.create(array, array.length);
        ListNodeManager.print(listNode);
        deleteNode(listNode.next);
        ListNodeManager.print(listNode);
    }
}
