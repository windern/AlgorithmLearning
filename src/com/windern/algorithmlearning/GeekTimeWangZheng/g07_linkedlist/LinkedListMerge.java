package com.windern.algorithmlearning.GeekTimeWangZheng.g07_linkedlist;

public class LinkedListMerge {

    public static Node merge(Node first, Node second) {
        if (first == null || second == null) {
            if (first == null && second == null) {
                return null;
            } else if (first == null) {
                return second;
            } else {
                return first;
            }
        }

        Node root = new Node();
        Node loop = root;

        Node firstLoop = first;
        Node secondLoop = second;
        while (firstLoop != null && secondLoop != null) {
            if (firstLoop.value < secondLoop.value) {
                Node tmp = firstLoop;
                firstLoop = firstLoop.next;
                tmp.next = null;
                loop.next = tmp;
                loop = loop.next;
            } else {
                Node tmp = secondLoop;
                secondLoop = secondLoop.next;
                tmp.next = null;
                loop.next = tmp;
                loop = loop.next;
            }
        }

        if (firstLoop == null) {
            loop.next = secondLoop;
        } else {
            loop.next = firstLoop;
        }

        return root.next;
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
        Node loop = node;
        while (loop != null) {
            System.out.print(loop.value + "->");
            loop = loop.next;
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
        Node first = createNode(1, 4, 7, 9);
        Node second = createNode(2, 5, 10, 12);
        Node result = merge(first, second);
        show(result);
    }
}
