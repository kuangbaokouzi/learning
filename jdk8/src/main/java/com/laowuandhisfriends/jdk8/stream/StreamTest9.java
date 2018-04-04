package com.laowuandhisfriends.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
//        list.stream().filter(str -> str.length() == 5).findFirst().ifPresent(System.out::println);
//        list.stream().mapToInt(str -> str.length()).filter(len -> len == 5).findFirst()
//                .ifPresent(System.out::println);

        list.stream().mapToInt(str -> {
            System.out.println(str);
            return str.length();
        }).filter(len -> len == 5).findFirst().ifPresent(System.out::println);
    }
}
