# 6. 从尾到头打印链表

## 题目描述
从尾到头反过来打印出每个结点的值。

## 解题思路

### 使用栈

- 值依次入栈，依次出栈

### 递归

- 递归也是用到栈，只不过用函数自己的栈

### 头插法

使用头插法可以得到一个逆序的链表。

头结点和第一个节点的区别：

- 头结点是在头插法中使用的一个额外节点，这个节点不存储值；
- 第一个节点就是链表的第一个真正存储值的节点。

**头插法原理**

- 本质是两个列表
- 从头部开始一次，加入到head的尾部，然后head尾部接上原来head的尾部

