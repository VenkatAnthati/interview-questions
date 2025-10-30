package com.practice.java.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        List<Integer> reverseOrderList = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseOrderList);
    }
}
