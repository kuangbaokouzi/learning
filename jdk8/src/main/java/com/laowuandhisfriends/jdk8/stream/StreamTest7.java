package com.laowuandhisfriends.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest7 {
    public static void main(String[] args) {
        //IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
