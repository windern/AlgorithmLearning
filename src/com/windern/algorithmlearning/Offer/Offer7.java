package com.windern.algorithmlearning.Offer;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Offer7 {

    // 缓存中序遍历跟节点的索引，方便直接查找
    public Map<Integer, Integer> mapInIndex = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            mapInIndex.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * 创建树
     * 递归方式
     * 核心点：
     * 1、计算左右树的长度，index相减是两个数之间的总数，不包含第一个index的数
     * 2、判断leftSize、rightSize是否大于0决定是否进行停止递归
     *
     * @param pre  前序数组
     * @param preL 前序起始位置
     * @param preR 前序结束位置
     * @param in   中序数组
     * @param inL  中序起始位置
     * @param inR  中序结束位置
     * @return 树
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        int val = pre[preL];
        TreeNode treeNode = new TreeNode(val);

        int index = mapInIndex.get(val);
        int leftSize = index - inL;
        int rightSize = inR - index;

        if (leftSize > 0) {
            treeNode.left = reConstructBinaryTree(pre, preL + 1, preL + 1 + leftSize - 1, in, inL, inL + leftSize - 1);
        }
        if (rightSize > 0) {
            treeNode.right = reConstructBinaryTree(pre, preR - rightSize + 1, preR, in, inR - rightSize + 1, inR);
        }

        return treeNode;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        Offer7 instance = new Offer7();
        TreeNode treeNode = instance.reConstructBinaryTree(pre, in);
        testPrintTreeNode(treeNode);
    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> printPre(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.value);
        list.addAll(printPre(root.left));
        list.addAll(printPre(root.right));

        return list;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> printIn(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.addAll(printIn(root.left));
        list.add(root.value);
        list.addAll(printIn(root.right));

        return list;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> printAfter(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.addAll(printAfter(root.left));
        list.addAll(printAfter(root.right));
        list.add(root.value);

        return list;
    }

    /**
     * 测试遍历
     */
    public static void testPrint() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;

        testPrintTreeNode(root);
    }

    /**
     * 遍历树
     *
     * @param root
     */
    public static void testPrintTreeNode(TreeNode root) {
        ArrayList<Integer> listPre = printPre(root);
        System.out.println(listPre);

        ArrayList<Integer> listIn = printIn(root);
        System.out.println(listIn);

        ArrayList<Integer> listAfter = printAfter(root);
        System.out.println(listAfter);
    }
}
