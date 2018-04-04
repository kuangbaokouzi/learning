package com.laowuandhisfriends.jdk8.stream;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("+++++++++++++");

        IntStream.rangeClosed(1, 5).map(item -> item * item).forEach(System.out::println);
        System.out.println("+++++++++++++");

        Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6))
                .flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
    }
}
