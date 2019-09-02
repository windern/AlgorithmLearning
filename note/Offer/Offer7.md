# 7. 重建二叉树

## 题目描述

根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

## 解题思路

前序遍历找到跟节点，然后在中序遍历中找到根节点，分成左右两部分，然后递归重新去生成

## 考察重点

- 前序遍历和中序遍历
- 复杂问题的分解能力，分解为构建左右子树的问题
- 发现小问题和大问题的本质是一致的，可以用递归的方式解决

## 个人总结

**最重要的是找到左右子树的长度**

#### 可以先用最原始的方式实现

```
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
```

#### 精简版

- 根据核心是计算左右子树的长度，可以通过父节点的in的左索引，来计算长度




