package com.windern.algorithmlearning.GeekTimeWangZheng.g08_stack;

import java.util.Stack;

public class ExpressionComputer {
    static final Stack<Integer> numStack = new Stack<>();
    static final Stack<Character> signStack = new Stack<>();

    public static int compute(String expression) throws Exception {
        char[] chars = expression.toCharArray();
        System.out.println(chars);
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                numStack.push(c - '0');
                showStack();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                handleSign(c);
            } else {
                throw new Exception("表达式格式有问题");
            }
            System.out.println("------");
        }

        while (!signStack.isEmpty()) {
            // 错误点：使用signStack.peek()
            char topSign = signStack.pop();
            Integer two = numStack.pop();
            Integer one = numStack.pop();
            int value = compute(one, two, topSign);
            numStack.push(value);
            showStack();
        }

        return numStack.pop();
    }

    public static void handleSign(char c) throws Exception {
        // 错误点：考虑signStack为空的情况
        if (signStack.isEmpty()) {
            signStack.push(c);
            showStack();
            return;
        }

        char topSign = signStack.peek();
        // 错误点：新加入的运算符比较高，才进行符号栈加入，否则进行运算
        boolean nowBig = compareSignSecondBigFirst(topSign, c);
        if (nowBig) {
            signStack.push(c);
            showStack();
            return;
        } else {
            Integer two = numStack.pop();
            Integer one = numStack.pop();
            // 错误点：改为弹出的情况
            topSign = signStack.pop();
            int value = compute(one, two, topSign);
            numStack.push(value);
            showStack();

            // 循环多次执行的情况
            handleSign(c);
        }
    }

    public static boolean compareSignSecondBigFirst(char first, char second) {
        int firstValue = -1;
        int secondValue = -1;
        if (first == '*' || first == '/') {
            firstValue = 1;
        } else if (first == '+' || first == '-') {
            firstValue = 0;
        }

        if (second == '*' || second == '/') {
            secondValue = 1;
        } else if (second == '+' || second == '-') {
            secondValue = 0;
        }

        return secondValue > firstValue;
    }

    public static int compute(int a, int b, char sign) throws Exception {
        if (sign == '+') {
            return a + b;
        } else if (sign == '-') {
            return a - b;
        } else if (sign == '*') {
            return a * b;
        } else if (sign == '/') {
            return a / b;
        }
        throw new Exception("计算符号不符");
    }

    public static void showStack() {
        System.out.println("numStack:" + numStack);
        System.out.println("signStack:" + signStack);
    }

    public static void main(String[] args) throws Exception {
        String expression = "4+2*5*8-6";
        int compute = compute(expression);
        System.out.print(compute);
    }

}
