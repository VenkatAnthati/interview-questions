package com.practice.java.questions;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateFinder {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 3, 2, 4, 6, 7, 3, 8);

        // using groupBy and filters
        Set<Integer> duplicateNumbers = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(duplicateNumbers);
         // using filter and set
        HashSet<Integer> set = new HashSet<>();
        Set<Integer> duplicateSet = list.stream().filter(e -> !set.add(e)).collect(Collectors.toSet());
        System.out.println(duplicateSet);
         // using collections frequency method
        Set<Integer> numbersDup = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());

        System.out.println(numbersDup);
    }
}
