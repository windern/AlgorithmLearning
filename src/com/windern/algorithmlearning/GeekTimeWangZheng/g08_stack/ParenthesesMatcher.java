package com.windern.algorithmlearning.GeekTimeWangZheng.g08_stack;

import java.util.Stack;

public class ParenthesesMatcher {

    public static boolean isParenthesesMatch(String expression) {
        Stack<Character> stack = new Stack<>();

        char[] chars = expression.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                char top = stack.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
            System.out.println(stack);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "({[()]})";
        boolean parenthesesMatch = isParenthesesMatch(expression);
        System.out.print(parenthesesMatch);
    }
}
