package com.practice.java.dsa;

public class IntegerDivision {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to handle overflow and work with absolute values
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Double temp and multiple until temp exceeds a
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        IntegerDivision solver = new IntegerDivision();

        System.out.println(solver.divide(10, 3));   // Output: 3
        System.out.println(solver.divide(7, -3));   // Output: -2
        System.out.println(solver.divide(-2147483648, -1)); // Output: 2147483647 (clamped)
        System.out.println(solver.divide(1, 1));    // Output: 1
    }
}
