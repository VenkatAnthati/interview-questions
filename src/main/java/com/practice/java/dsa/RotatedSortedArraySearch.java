package com.practice.java.dsa;

public class RotatedSortedArraySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is in the left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // Target is in the right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch searcher = new RotatedSortedArraySearch();

        System.out.println(searcher.search(new int[]{4,5,6,7,0,1,2}, 0)); // Output: 4
        System.out.println(searcher.search(new int[]{4,5,6,7,0,1,2}, 3)); // Output: -1
        System.out.println(searcher.search(new int[]{1}, 0));
    }
}

