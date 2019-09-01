package com.windern.algorithmlearning.Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Offer6 {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用栈方式
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> printReverseLinkedWithStack(Node root) {
        Stack<Integer> stack = new Stack<>();

        Node loopNode = root;
        while (loopNode != null) {
            stack.push(loopNode.value);
            loopNode = loopNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    /**
     * 使用递归方式
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> printReverseLinkedWithRecursive(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            list.addAll(printReverseLinkedWithRecursive(root.next));
            list.add(root.value);
        }

        return list;
    }

    /**
     * 使用头插法
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> printReverseLinkedWithHeadInsert(Node root) {
        Node head = new Node(-1);

        while(root != null) {
            // 原列表继续向下走
            // 新列表的后面加入新节点，新节点加上原来新列表的末尾
            Node meno = root.next;
            root.next = head.next;
            head.next = root;
            root = meno;
        }

        ArrayList<Integer> list = new ArrayList<>();

        Node loopNode = head.next;
        while (loopNode != null) {
            list.add(loopNode.value);
            loopNode = loopNode.next;
        }

        return list;
    }

    public static void main(String[] args) {
        Offer6 instance = new Offer6();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        ArrayList<Integer> listWithStack = instance.printReverseLinkedWithStack(node1);
        System.out.println(listWithStack);

        ArrayList<Integer> listWithRecursive = instance.printReverseLinkedWithRecursive(node1);
        System.out.println(listWithRecursive);

        ArrayList<Integer> listWithHeadInsert = instance.printReverseLinkedWithHeadInsert(node1);
        System.out.println(listWithHeadInsert);
    }
}


