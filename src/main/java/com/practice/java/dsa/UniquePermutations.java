package com.practice.java.dsa;

import java.util.*;

public class UniquePermutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Important: sort to handle duplicates
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates: only use the first duplicate in this recursion layer
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // Test the function
    public static void main(String[] args) {
        UniquePermutations solver = new UniquePermutations();

        System.out.println(solver.permuteUnique(new int[]{1, 1, 2}));
        // Output: [[1,1,2], [1,2,1], [2,1,1]]

        System.out.println(solver.permuteUnique(new int[]{1, 2, 3}));
        // Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
    }
}

