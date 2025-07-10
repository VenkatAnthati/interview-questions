package com.practice.java.dsa;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with the first triplet

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                // Update the closestSum if the current is closer
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }
                // Move pointers based on comparison
                if (currSum < target) {
                    left++;
                } else if (currSum > target) {
                    right--;
                } else {
                    // Exact match
                    return currSum;
                }
            }
        }

        return closestSum;
    }

    // Test
    public static void main(String[] args) {
        ThreeSumClosest solver = new ThreeSumClosest();

        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(solver.threeSumClosest(nums1, target1)); // Output: 2

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println(solver.threeSumClosest(nums2, target2)); // Output: 0
    }
}

