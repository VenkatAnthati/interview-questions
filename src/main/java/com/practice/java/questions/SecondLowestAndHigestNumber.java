package com.practice.java.questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLowestAndHigestNumber {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 3, 10, 20, 30, 15, 35, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
        Integer secondHighest = list.stream().sorted(Collections.reverseOrder())
                .distinct().limit(2).skip(1).findFirst().get();
        Integer secondHighest1 = list.stream().sorted(Collections.reverseOrder())
                .distinct().skip(1).findFirst().get();
        System.out.println(secondHighest);
        System.out.println(secondHighest1);
    }
}
