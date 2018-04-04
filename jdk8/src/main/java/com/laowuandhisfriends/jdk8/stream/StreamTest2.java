package com.laowuandhisfriends.jdk8.stream;

import java.util.stream.IntStream;

public class StreamTest2 {
    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 100).map(i -> 2 * i).reduce(0, Integer::sum));
    }
}
