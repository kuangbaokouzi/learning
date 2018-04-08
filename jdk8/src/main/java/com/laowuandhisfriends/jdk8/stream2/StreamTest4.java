package com.laowuandhisfriends.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

        // try with resources
        try (Stream<String> stream = list.stream()) {
            NullPointerException nullPointerException = new NullPointerException("nnn");
            stream.onClose(() -> {
                System.out.println("aaa");
                throw new RuntimeException("xxx");
            }).onClose(() -> {
                System.out.println("bbb");

                // suppressed exception
                throw new ArithmeticException("yyy");
            }).onClose(() -> {
                System.out.println("ccc");

                // suppressed exception
                throw new RuntimeException("zzz");
            }).onClose(() -> {
                System.out.println("ddd");
                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("ddd");
                // cause of the same exception, suppressed will not be present.
                throw nullPointerException;
            }).forEach(System.out::println);
        }
    }
}
