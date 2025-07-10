package com.practice.java.questions;

import java.util.Arrays;
import java.util.List;

public class NumberSquareAverage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 20, 30, 15);
        // average of greater than 1000

        double avg = list.stream().map(e -> e*e)
                .filter(e -> e>100)
                .mapToInt(e -> e)
                .average().getAsDouble();
        System.out.println(avg);
    }
}
