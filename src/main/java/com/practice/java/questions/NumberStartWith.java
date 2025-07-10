package com.practice.java.questions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStartWith {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 222, 234, 890, 432, 236, 211, 22);

        List<Integer> numbersWith2 = numbers.stream().map(e -> String.valueOf(e))
                .filter(e -> e.startsWith("2"))
                .map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(numbersWith2);
    }
}
