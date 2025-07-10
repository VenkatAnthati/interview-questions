package com.practice.java.dsa;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // dp[i][j] = true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty string matches empty pattern

        // Initialize first row for patterns with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // Build the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    // '*' matches zero (dp[i][j-1]) or more (dp[i-1][j]) characters
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    // Test the function
    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();

        System.out.println(wm.isMatch("aa", "a"));    // false
        System.out.println(wm.isMatch("aa", "*"));    // true
        System.out.println(wm.isMatch("cb", "?a"));   // false
    }
}

