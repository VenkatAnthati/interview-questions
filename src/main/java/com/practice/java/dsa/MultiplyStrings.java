package com.practice.java.dsa;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n]; // Max digits in the product

        // Multiply each digit of num1 and num2 and accumulate in product[]
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i)-'0' ;

            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j)-'0';
                int sum = digit1 * digit2 + product[i + j + 1];

                product[i + j + 1] = sum % 10; // Place unit digit
                product[i + j] += sum / 10;    // Carry to next left
            }
        }

        // Build result string, skipping leading zeros
        StringBuilder result = new StringBuilder();
        for (int num : product) {
            if (result.length() == 0 && num == 0) continue;
            result.append(num);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    // Testing the function
    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("2", "3"));         // Output: "6"
        System.out.println(ms.multiply("123", "456"));     // Output: "56088"
    }
}

