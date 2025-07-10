package com.practice.java.dsa;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = buildNext(result);
        }

        return result;
    }

    private String buildNext(String input) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char currentChar = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                sb.append(count).append(currentChar);
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        // Append the last group
        sb.append(count).append(currentChar);

        return sb.toString();
    }

    // Example usage
    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(1)); // Output: "1"
        System.out.println(cas.countAndSay(4)); // Output: "1211"
    }
}

