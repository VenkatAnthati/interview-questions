package com.practice.java.dsa;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        // Traverse characters of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            // Compare with each string
            for (int j = 1; j < strs.length; j++) {
                char c1 = strs[j].charAt(i);
                // Mismatch or end of one string
                if (i >= strs[j].length() || c1 != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(input1));  // Output: "fl"

        String[] input2 = {"ardog", "aracecar", "acar"};
        System.out.println(solution.longestCommonPrefix(input2));  // Output: ""
    }
}

