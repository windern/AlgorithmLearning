package com.windern.algorithmlearning.Offer;

import apple.laf.JRSUIUtils;

public class Offer8 {
    public static class TreeParentNode {
        public int value;
        public TreeParentNode left;
        public TreeParentNode right;
        public TreeParentNode parent;

        public TreeParentNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeParentNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public TreeParentNode getNext(TreeParentNode root) {
        if (root.right != null) {
            // 是父节点，且右子节点存在，从右子树中找
            TreeParentNode loopNode = root.right;
            while (loopNode.left != null) {
                loopNode = loopNode.left;
            }
            return loopNode;
        } else {
            // 右子树不存在，向上从父节点找
            TreeParentNode loopNode = root;
            while (loopNode.parent != null) {
                if (loopNode.parent.left == loopNode) {
                    // 如果发现当前是左边的树，说明找到返回父及诶单
                    return loopNode.parent;
                } else {
                    loopNode = loopNode.parent;
                }
            }

            return null;
        }
    }

    public static void main(String[] args) {

        TreeParentNode one = new TreeParentNode(1);
        TreeParentNode two = new TreeParentNode(2);
        TreeParentNode three = new TreeParentNode(3);
        TreeParentNode four = new TreeParentNode(4);
        TreeParentNode five = new TreeParentNode(5);
        TreeParentNode six = new TreeParentNode(6);
        TreeParentNode seven = new TreeParentNode(7);
        TreeParentNode eight = new TreeParentNode(8);
        TreeParentNode nine = new TreeParentNode(9);

        one.left = two;
        one.right = three;
        two.parent = one;
        three.parent = one;

        two.left = four;
        two.right = five;
        four.parent = two;
        five.parent = two;

        three.left = six;
        three.right = seven;
        six.parent = three;
        seven.parent = three;

        five.left = eight;
        five.right = nine;
        eight.parent = five;
        nine.parent = five;

        Offer8 instance = new Offer8();
        TreeParentNode fiveNext = instance.getNext(five);
        System.out.println("fiveNext:" + fiveNext);

        TreeParentNode nineNext = instance.getNext(nine);
        System.out.println("nineNext:" + nineNext);

        TreeParentNode sevenNext = instance.getNext(seven);
        System.out.println("sevenNext:" + sevenNext);

        TreeParentNode sixNext = instance.getNext(six);
        System.out.println("sixNext:" + sixNext);
    }
}
