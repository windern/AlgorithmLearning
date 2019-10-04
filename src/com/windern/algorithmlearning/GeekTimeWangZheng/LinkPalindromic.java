package com.windern.algorithmlearning.GeekTimeWangZheng;

/**
 * 链表判断是否是回文
 */
public class LinkPalindromic {


    public static boolean isPalindromic(Node node) {
        if (node == null) {
            return false;
        }

        if (node.next == null) {
            return true;
        }

        Node slow = node;
        Node fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node leftLastNode = slow;

        // 是否是奇数
        boolean isCountOdd = false;
        if (fast.next == null) {
            // 是奇数个
            mid = new Node(slow.value);//错误点，要多一个节点，需要重新加一个
            mid.next = slow.next;
            slow.next = null;
            leftLastNode = slow;
            isCountOdd = true;
        } else {
            mid = slow.next;
            slow.next = null;
            leftLastNode = slow;
            isCountOdd = false;
        }

        Node left = node;
        Node right = mid;
        Node newRightNode = revertNode(right);

        boolean result = checkSame(left, newRightNode);
        Node selfRightNode = revertNode(newRightNode);
        if (isCountOdd) {
            // 删除掉多的一个节点
            leftLastNode.next = selfRightNode.next;
        } else {
            leftLastNode.next = selfRightNode;
        }

        return result;
    }

    public static Node getMidNode(Node first) {
        if (first == null) {
            return null;
        }

        Node slow = first;
        Node fast = first;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 递归实现翻转链表
     * @param node 头节点
     * @return 翻转后的链表
     */
    public static Node revertNode(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node left = revertNode(node.next);
        Node loop = left;
        while (loop.next != null) {
            loop = loop.next;
        }
        node.next = null;
        loop.next = node;

        return left;
    }

    /**
     * 头插法实现翻转链表
     * @param node 头节点
     * @return 翻转后的链表
     */
    public static Node revertNodeInsert(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node newNode = new Node();
        Node nextNode = node;
        while(nextNode != null) {
            Node tmp = nextNode.next;
            nextNode.next = newNode.next;
            newNode.next = nextNode;
            nextNode = tmp;
        }

        return newNode.next;
    }

    public static boolean checkSame(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        Node firstLoop = first;
        Node secondLoop = second;
        while (firstLoop != null && secondLoop != null) {
            if (firstLoop.value == secondLoop.value) {
                firstLoop = firstLoop.next;
                secondLoop = secondLoop.next;
            } else {
                return false;
            }
        }

        if (firstLoop == null && secondLoop == null) {
            return true;
        } else {
            return false;
        }
    }


    public static class Node {
        public char value;
        public Node next;

        public Node() {

        }

        public Node(char value) {
            this(value, null);
        }

        public Node(char value, Node next) {
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
        testRevertNodeInsert();

        test1();
        test2();
        test3();
        test4();
    }

    public static void testRevertNodeInsert() {
        Node a = new Node('a');
        Node b = new Node('b', a);
        Node c = new Node('c', b);
        Node root = new Node('d', c);
        show(root);
        Node node = revertNodeInsert(root);
        show(node);
        System.out.println();
    }

    public static void test1() {
        Node a = new Node('a');
        Node b = new Node('b', a);
        Node c = new Node('c', b);
        Node d = new Node('b', c);
        Node root = new Node('a', d);
        show(root);
        boolean palindromic = LinkPalindromic.isPalindromic(root);
        System.out.println(palindromic);
        show(root);
        System.out.println();
    }

    public static void test2() {
        Node a = new Node('a');
        Node b = new Node('b', a);
        Node c = new Node('b', b);
        Node root = new Node('a', c);
        show(root);
        boolean palindromic = LinkPalindromic.isPalindromic(root);
        System.out.println(palindromic);
        show(root);
        System.out.println();
    }

    public static void test3() {
        Node a = new Node('a');
        Node root = new Node('a', a);
        show(root);
        boolean palindromic = LinkPalindromic.isPalindromic(root);
        System.out.println(palindromic);
        show(root);
        System.out.println();
    }

    public static void test4() {
        Node root = new Node('a');
        show(root);
        boolean palindromic = LinkPalindromic.isPalindromic(root);
        System.out.println(palindromic);
        show(root);
        System.out.println();
    }
}
