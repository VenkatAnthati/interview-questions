package com.practice.java.dsa;

import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int start, int target,
                                  List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], current, result);
            current.remove(current.size() - 1);  // backtrack
        }
    }

    // Test the function
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        // Output: [[2, 2, 3], [7]]

        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        System.out.println(combinationSum(new int[]{2}, 1));
        // Output: []
    }
}