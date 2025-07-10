package com.practice.java.dsa;

import java.util.ArrayList;
import java.util.List;

public class HeapAlgorithm {

    // Function to generate permutations
    public static void generate(int n, int[] arr) {
        if (n == 1) {
            printArray(arr);
            return;
        }
        List ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            generate(n - 1, arr);

            // If n is even, swap i and n-1
            // If n is odd, swap 0 and n-1
            if (n % 2 == 0) {
                swap(arr, i, n - 1);
            } else {
                swap(arr, 0, n - 1);
            }
        }
    }

    // Helper method to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to print the array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        generate(data.length, data);
    }
}

