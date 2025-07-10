package com.practice.java.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OddEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 2, 3, 45, 67, 9, 90,87,8,2);

        List<Integer> evenNumbers = numbers.stream().filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);

        List<Integer> oddNumbers = numbers.stream().filter(e -> e % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);

    }
}
