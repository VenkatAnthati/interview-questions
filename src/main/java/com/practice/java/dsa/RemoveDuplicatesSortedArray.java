package com.practice.java.dsa;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;  // slow pointer

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;  // move to next unique slot
                nums[i] = nums[j];  // copy unique value forward
            }
        }

        return i + 1;  // Number of unique elements
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray remover = new RemoveDuplicatesSortedArray();

        int[] nums1 = {1, 1, 2};
        int k1 = remover.removeDuplicates(nums1);
        System.out.println("k = " + k1);
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = remover.removeDuplicates(nums2);
        System.out.println("k = " + k2);
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();
    }
}

