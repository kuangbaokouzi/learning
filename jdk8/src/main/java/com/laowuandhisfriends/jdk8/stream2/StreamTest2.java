package com.laowuandhisfriends.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
        System.out.println(list.stream().sorted().collect(Collectors.joining(", ")));
        Collections.sort(list, (item, item2) -> item.length() - item2.length());
        System.out.println(list);
        Collections.sort(list, (item, item2) -> item2.length() - item.length());
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

        System.out.println("++++++++++++++");

        list.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(list);

        System.out.println("++++++++++++++");

        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);

        System.out.println("++++++++++++++");

        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.comparing(String::toUpperCase)));
        System.out.println(list);

        System.out.println("++++++++++++++");

        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.comparing(String::toUpperCase, Comparator.reverseOrder())));
        System.out.println(list);

        System.out.println("++++++++++++++");

        Collections.sort(list, Comparator.comparingInt(String::length)
                .thenComparing(Comparator.comparing(String::toUpperCase, Comparator.reverseOrder())));
        System.out.println(list);

        System.out.println("++++++++++++++");

        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.comparing(String::toUpperCase, Comparator.reverseOrder()))
                .thenComparing(Comparator.reverseOrder()));
        System.out.println(list);

    }
}
