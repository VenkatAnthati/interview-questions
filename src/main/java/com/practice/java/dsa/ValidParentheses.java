package com.practice.java.dsa;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Match closing brackets
            else {
                if (stack.isEmpty()) {
                    return false; // No opening bracket to match
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();

        System.out.println(validator.isValid("()"));       // true
        System.out.println(validator.isValid("()[]{}"));   // true
        System.out.println(validator.isValid("(]"));       // false
        System.out.println(validator.isValid("([])"));     // true
        System.out.println(validator.isValid("((("));      // false
        System.out.println(validator.isValid("{[()]}"));   // true
    }
}

