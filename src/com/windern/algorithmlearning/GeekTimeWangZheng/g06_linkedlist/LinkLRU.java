package com.windern.algorithmlearning.GeekTimeWangZheng.g06_linkedlist;

/**
 * 链表实现LRU算法
 */
public class LinkLRU {

    public Node first;
    public int m = 10;

    public void use(int i) {
        if (first == null) {
            first = new Node(i);
            return;
        }

        if (first.value == i) {
            return;
        }

        Node loop = first;
        Node pre = loop;
        Node find = null;
        int count = 0;
        while (loop.next != null) {
            if (loop.next.value == i) {
                pre = loop;//错误点：少写了
                find = loop.next;
                break;
            }
            count++;
            pre = loop;
            loop = loop.next;
        }


        if (find != null) {
            // 情况1：找到了，放在最前面
            pre.next = find.next;
            find.next = first;//错误点：写成了find.next = first.next，多了一级
            first = find;
        } else {
            // 情况2：没有找到，新增一个node放在最前面，需要知道倒数第二个节点
            if (count >= m - 1) {
                // 删除最后一个节点
                pre.next = null;
            }
            find = new Node(i);
            find.next = first;
            first = find;
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void show(Node node) {
        Node loop = node;
        while (loop != null) {
            // 错误点：写成node了
            System.out.print(loop.value + "->");
            loop = loop.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkLRU linkLRU = new LinkLRU();
        for (int i = 1; i <= 10; i++) {
            linkLRU.use(i);
        }
        show(linkLRU.first);

        linkLRU.use(3);
        show(linkLRU.first);
        linkLRU.use(11);
        show(linkLRU.first);
        linkLRU.use(11);
        show(linkLRU.first);
        linkLRU.use(12);
        show(linkLRU.first);

    }

}
