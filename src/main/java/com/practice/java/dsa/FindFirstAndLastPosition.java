package com.practice.java.dsa;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }
  // {5,7,7,8,8,10}
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        FindFirstAndLastPosition finder = new FindFirstAndLastPosition();

        System.out.println(Arrays.toString(finder.searchRange(new int[]{5,7,7,8,8,10}, 8))); // Output: [3, 4]
        System.out.println(Arrays.toString(finder.searchRange(new int[]{5,7,7,8,8,10}, 6))); // Output: [-1, -1]
        System.out.println(Arrays.toString(finder.searchRange(new int[]{}, 0)));             // Output: [-1, -1]

    }
}

