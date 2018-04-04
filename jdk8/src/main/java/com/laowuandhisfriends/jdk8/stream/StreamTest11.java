package com.laowuandhisfriends.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hi", "Hello", "world");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list.stream().flatMap(e1 -> list2.stream().map(e2 -> e1 + " " + e2)).forEach(System.out::println);
    }
}
