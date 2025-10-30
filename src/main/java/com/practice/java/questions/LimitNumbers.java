package com.practice.java.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitNumbers {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3);
        List<Integer> firstFiveNumbers = list.stream().limit(5).collect(Collectors.toList());
        System.out.println(firstFiveNumbers);
        Integer sum = list.stream().limit(5).reduce((a, b) -> a + b).get();
        System.out.println(sum);
        // skip first five numbers
        List<Integer> skipNumbers = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(skipNumbers);
        Integer sumAfterSkip = list.stream().skip(5).reduce((a, b) -> a + b).get();
        System.out.println(sumAfterSkip);
    }
}
