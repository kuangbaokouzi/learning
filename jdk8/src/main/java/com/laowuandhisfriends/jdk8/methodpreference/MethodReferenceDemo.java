package com.laowuandhisfriends.jdk8.methodpreference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        list.forEach(System.out::println);
    }
}
