package com.windern.algorithmlearning.GeekTimeWangZheng.g07_linkedlist;

public class DeleteKNode {

    public static Node deleteKNode(Node node, int k) {
        Node fast = node;
        int count = 1;//从1开始
        while (fast != null && count < k) {
            count++;
            fast = fast.next;
        }

        if (fast == null) {
            // 总共没有k的长度
            return node;
        }

        Node slow = node;
        Node pre = null;
        while (fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (pre == null) {
            node = node.next;
        } else {
            pre.next = pre.next.next;
        }

        return node;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void show(Node node) {
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static Node createNode(int... values) {
        Node first = new Node();
        Node loop = first;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            Node node = new Node(value);
            loop.next = node;
            loop = loop.next;
        }
        return first.next;
    }

    public static void main(String[] args) {
        Node node = createNode(1, 2, 3, 4, 5, 6);
        Node newNode = deleteKNode(node, 2);
        show(newNode);

        Node node2 = createNode(1);
        Node newNode2 = deleteKNode(node2, 2);
        show(newNode2);
    }
}
