package com.practice.java.dsa;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Test function
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        ri.rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        // Output:
        // [15, 13, 2, 5]
        // [14, 3, 4, 1]
        // [12, 6, 8, 9]
        // [16, 7, 10, 11]
    }
}

