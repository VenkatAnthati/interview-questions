package com.practice.java.dsa;

import java.util.*;

public class FindSubstringConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        // Create a frequency map of the words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        // Slide the window for each possible offset (0 to wordLen - 1)
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If it's a valid word
                if (wordCount.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);

                    // Shrink the window if count exceeds
                    while (window.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                    }

                    // If window size matches, add the start index
                    if (right - left == totalLen) {
                        result.add(left);
                    }
                } else {
                    // Reset the window if invalid word
                    window.clear();
                    left = right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindSubstringConcatenation solver = new FindSubstringConcatenation();
//         String str = "barfoothefoobarman";
//         String str1 = "foobar";
//         String str2 = "barfoo";
//        int index = str.indexOf(str2);
//        System.out.println(index);
        System.out.println(solver.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        // Output: [0, 9]

       // System.out.println(solver.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        // Output: []

       // System.out.println(solver.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        // Output: [6, 9, 12]
    }
}
