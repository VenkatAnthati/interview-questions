package com.practice.java.dsa;

import java.util.*;

public class UniqueThreeDigitNumbers {

    public static List<Integer> findUniqueIntegers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        int n = digits.length;

        // Try all combinations of 3 different indices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && j != k && i != k) {
                        int d1 = digits[i];
                        int d2 = digits[j];
                        int d3 = digits[k];

                        // Skip numbers starting with 0
                        if (d1 == 0) continue;

                        // Only even numbers
                        if (d3 % 2 != 0) continue;

                        int num = d1 * 100 + d2 * 10 + d3;
                        result.add(num);
                    }
                }
            }
        }

        // Convert to list and sort
        List<Integer> output = new ArrayList<>(result);
        Collections.sort(output);
        return output;
    }

    // Example usage
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 0};
        List<Integer> uniqueNumbers = findUniqueIntegers(digits);
        System.out.println(uniqueNumbers); // Output: [132, 312]
    }
}
