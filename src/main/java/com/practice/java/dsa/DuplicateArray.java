package com.practice.java.dsa;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateArray {
    public static long countDuplicates(int[] nums) {
        return Arrays.stream(nums)
                .boxed() // Convert int to Integer for use in collectors
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .count(); // Count how many distinct elements have duplicates
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 4, 5, 1, 1};
        System.out.println(countDuplicates(nums)); // Output: 2 (1 and 2 are duplicates)
    }
}
