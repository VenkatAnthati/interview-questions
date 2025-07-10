package com.practice.java.dsa;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // Sort characters in the word
            String key = new String(chars); // Anagram group key

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // Test the function
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        System.out.println(ga.groupAnagrams(new String[]{""}));
        // Output: [[""]]

        System.out.println(ga.groupAnagrams(new String[]{"a"}));
        // Output: [["a"]]
    }
}

