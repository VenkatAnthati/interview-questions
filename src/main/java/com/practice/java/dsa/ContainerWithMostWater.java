package com.practice.java.dsa;


public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;
            max = Math.max(max, area);

            // Move the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max Area: " + maxArea(heights1)); // Output: 49

        int[] heights2 = {1,1};
        System.out.println("Max Area: " + maxArea(heights2)); // Output: 1
    }
}
