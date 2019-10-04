package com.windern.algorithmlearning.GeekTimeWangZheng.g07_linkedlist;

public class CheckCircle {

    public static boolean checkCircle(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void show(Node node) {
        Node loop = node;
        while (loop != null) {
            System.out.print(loop.value + "->");
            loop = loop.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2, a);
        Node c = new Node(3, b);
        Node d = new Node(4, c);
        Node e = new Node(5, d);
        a.next = d;
        Node root = new Node(6, e);
        boolean result = checkCircle(root);
        System.out.println(result);
    }
}
