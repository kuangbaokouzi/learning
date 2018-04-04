package com.laowuandhisfriends.jdk8.general;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(System.out::println);
        System.out.println(optional.orElse("world"));
        System.out.println(optional.orElseGet(() -> "welcome"));
    }
}
