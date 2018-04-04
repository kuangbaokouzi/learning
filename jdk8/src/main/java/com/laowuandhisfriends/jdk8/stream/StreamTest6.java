package com.laowuandhisfriends.jdk8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest6 {
    public static void main(String[] args) {
        Stream.of("hello", "world", "welcome").map(e -> e.toUpperCase() + e.substring(1))
                .forEach(System.out::println);

        System.out.println("+++++++++++++");

        Stream.of("hello", "world", "welcome").map(e -> e.substring(0, 1).toUpperCase() + e.substring(1))
                .forEach(System.out::println);
    }
}
