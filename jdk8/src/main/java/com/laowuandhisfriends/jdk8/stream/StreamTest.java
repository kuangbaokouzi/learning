package com.laowuandhisfriends.jdk8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream stream = Stream.of("hello", "world", "welcome");
        Stream stream2 = Stream.of(new String[]{"hello", "world", "welcome"});
        Stream stream3 = Arrays.stream(new String[]{"hello", "world", "welcome"});
        Stream stream4 = Arrays.asList("hello", "world", "welcome").stream();

        IntStream.of(1, 3, 4, 5, 6, 7).forEach(System.out::print);
        System.out.println("\n+++++++++++++");
        IntStream.range(3,8).forEach(System.out::print);
        System.out.println("\n+++++++++++++");
        IntStream.rangeClosed(3,8).forEach(System.out::print);
    }
}
