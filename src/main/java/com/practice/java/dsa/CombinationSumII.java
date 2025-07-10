package com.practice.java.dsa;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort to handle duplicates
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int start, int target,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same depth
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Prune search

            current.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], current, result); // i + 1: use only once
            current.remove(current.size() - 1);  // backtrack
        }
    }

    // Test the function
    public static void main(String[] args) {
        CombinationSumII cs2 = new CombinationSumII();

        System.out.println(cs2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        // Output: [[1,1,6], [1,2,5], [1,7], [2,6]]

        System.out.println(cs2.combinationSum2(new int[]{2,5,2,1,2}, 5));
        // Output: [[1,2,2], [5]]
    }
}

