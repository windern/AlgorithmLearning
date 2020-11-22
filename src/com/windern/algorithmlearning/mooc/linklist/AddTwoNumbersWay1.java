package com.windern.algorithmlearning.mooc.linklist;

/**
 * 445. 两数相加 II
 *
 * @author windern
 * @date 2020/11/22 23:41
 **/
public class AddTwoNumbersWay1 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverse(l1);
        ListNodeManager.print(l1Reverse);
        ListNode l2Reverse = reverse(l2);
        ListNodeManager.print(l2Reverse);

        ListNode lowResult = addFromLow(l1Reverse, l2Reverse);
        ListNodeManager.print(lowResult);

        ListNode highResult = reverse(lowResult);
        return highResult;
    }

    public static ListNode addFromLow(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);

        ListNode cur = sentry;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        // 保存进位信息
        int left = 0;
        // 注意点1：两个同时为空才停止，可能需要left和剩余的一个链表进行计算，所以一直计算下去
        while (cur1 != null || cur2 != null) {
            int cur1Val = 0;
            int cur2Val = 0;
            if (cur1 != null) {
                cur1Val = cur1.val;
            }
            if (cur2 != null) {
                cur2Val = cur2.val;
            }

            // 加法后的和
            int sum = left + cur1Val + cur2Val;
            // 进位信息
            left = sum / 10;
            // 加法后剩下的数字
            ListNode item = new ListNode(sum % 10);
            cur.next = item;
            cur = item;

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }

        // 注意点2：如果链表都是空了，最后还有进位信息，要单独加上
        if (left > 0) {
            cur.next = new ListNode(left);
        }

        return sentry.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode sentry = new ListNode(-1);
        // 注意点1：哨兵后面不加head，是所有节点都往哨兵上加

        // 注意点2：cur起始从链表开始
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            // 注意点3：cur插入到哨兵后面，cur.next放原来哨兵的next
            cur.next = sentry.next;
            sentry.next = cur;

            cur = next;
        }

        return sentry.next;
    }

    public static void main(String[] args) {
        int[] array1 = {7, 2, 4, 3};
        int[] array2 = {5, 6, 4};
        ListNode l1 = ListNodeManager.create(array1, array1.length);
        ListNode l2 = ListNodeManager.create(array2, array2.length);
        ListNodeManager.print(l1);
        ListNodeManager.print(l2);
        ListNode result = addTwoNumbers(l1, l2);
        ListNodeManager.print(result);
    }
}
