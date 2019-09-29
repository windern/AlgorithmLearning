package com.windern.algorithmlearning.Algorithms4th.Sort;

public class LinkMerge extends Example {

    public static class Node implements Comparable<Node> {

        private Comparable val;
        private Node next;

        public Node() {

        }

        public Node(Comparable val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val.compareTo(o.val);
        }
    }

    public static Node createLinkedList(Integer[] array) {
        if (array == null || array.length == 0) {
            return new Node();
        }

        Node first = new Node(array[0]);
        Node loopNode = first;
        for (int i = 1; i < array.length; i++) {
            Node next = new Node(array[i]);
            loopNode.next = next;
            loopNode = loopNode.next;
        }

        return first;
    }

    public static void show(Node node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("");
    }

    public static Node sort(Node first) {
        if (first == null || first.next == null) {
            return first;
        }

        Node mid = getMid(first);
        Node second = mid.next;
        mid.next = null;

        Node left = sort(first);
        Node right = sort(second);
        return merge(left, right);
    }

    public static Node getMid(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node slow = node;
        // 关键点：如果fast = node，那么会栈溢出
        // 本身fast = node获取中间节点的方法没错，但是如果仅有两个节点，我们也要返回第一个，这样能和上面的merge配合起来
        Node fast = node.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node newNode = new Node();
        // 保留头部
        Node tmp = newNode;

        while (left != null && right != null) {
            if (less(left, right)) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            // 往下接着走
            tmp = tmp.next;
        }

        if (left != null) {
            tmp.next = left;
        } else {
            tmp.next = right;
        }

        // 第二个节点才是开始的几点
        return newNode.next;
    }

    /**
     * 后面偏移后的节点
     *
     * @param node 起始节点
     * @param sz   偏移大小
     * @return 后面偏移后的节点
     */
    public static Node next(Node node, int sz) {
        int count = 0;
        Node loopNode = node;
        while (loopNode != null && count < sz) {
            count++;
            loopNode = loopNode.next;
        }

        return loopNode;
    }

    public static void main(String[] args) {
        Integer[] array = randomArray(10);
        Node first = createLinkedList(array);

        show(first);
        Node sortHead = sort(first);
        show(sortHead);
    }

}
