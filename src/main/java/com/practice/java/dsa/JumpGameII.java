package com.practice.java.dsa;

public class JumpGameII {
    public int jump(int[] nums) {
        int jumps = 0, end = 0, farthest = 0;

        // We go until second-to-last index (we don't need to jump from the last index)
        for (int i = 0; i < nums.length - 1; i++) { // 2, 3, 1, 1, 4
            System.out.println("Jumping : "+nums[i]);
            farthest = Math.max(farthest, i + nums[i]);

            // Time to jump to the next range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }

    // Test the solution
    public static void main(String[] args) {
        JumpGameII solver = new JumpGameII();

        System.out.println(solver.jump(new int[]{2, 3, 1, 1, 4})); // Output: 2
        System.out.println(solver.jump(new int[]{2, 3, 0, 1, 4})); // Output: 2
    }
}

