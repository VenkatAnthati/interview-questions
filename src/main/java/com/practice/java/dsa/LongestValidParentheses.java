package com.practice.java.dsa;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for first valid substring
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop(); // pop the matching '(' index or base
                if (stack.isEmpty()) {
                    stack.push(i); // reset base
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        LongestValidParentheses solver = new LongestValidParentheses();

        System.out.println(solver.longestValidParentheses("(()"));       // Output: 2
        System.out.println(solver.longestValidParentheses(")()())"));    // Output: 4
        System.out.println(solver.longestValidParentheses(""));          // Output: 0
    }
}

