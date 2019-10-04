package com.windern.algorithmlearning.GeekTimeWangZheng.g06_linkedlist;

public class LinkJosephusCircle {

    public static void loopDelete(Node node) {
        Node loop = node;
        Node pre = node;
        int count = 1;
        while (loop != null) {
            if (count % 3 == 0) {
                System.out.println("time: " + (count / 3) + ",count: " + count + ", delete: " + loop.value);
                pre.next = loop.next;
                if (pre.next == pre) {
                    System.out.println("last item:" + pre.value);
                    break;
                }
            }
            count++;
            pre = loop;
            loop = loop.next;
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
            System.out.print(loop.value + "->");
            loop = loop.next;
            if (loop == node) {
                // 如果有环，到起始点停止
                break;
            }
        }
        System.out.print(loop.value);
        System.out.println();
    }

    public static Node createCircle(int n) {
        Node first = new Node(1);
        Node loop = first;
        for (int i = 2; i <= n; i++) {
            Node node = new Node(i);
            loop.next = node;
            loop = loop.next;
        }
        loop.next = first;
        return first;
    }

    public static void main(String[] args) {
        Node circle = createCircle(41);
        show(circle);
        loopDelete(circle);
    }
}
