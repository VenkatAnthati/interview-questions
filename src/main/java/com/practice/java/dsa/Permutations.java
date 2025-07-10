package com.practice.java.dsa;

import java.util.*;
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Add a copy of current
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, current, used, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // Test the function
    public static void main(String[] args) {
        Permutations perm = new Permutations();

        System.out.println(perm.permute(new int[]{1, 2, 3}));
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        System.out.println(perm.permute(new int[]{0, 1}));
        // Output: [[0,1],[1,0]]

        System.out.println(perm.permute(new int[]{1}));
        // Output: [[1]]
    }
}

