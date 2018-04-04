package com.laowuandhisfriends.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        list.stream().map(str -> str.split(" ")).flatMap(Arrays::stream).distinct()
                .forEach(System.out::println);
    }
}
