package com.laowuandhisfriends.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test3 {
    public static void main(String[] args) {
        Test3Interface test3Interface = () -> {
        };
        System.out.println(test3Interface.getClass().getInterfaces()[0]);
        Test3Interface2 test3Interface2 = () -> {
        };
        System.out.println(test3Interface2.getClass().getInterfaces()[0]);

        System.out.println("+++++++++++++++++++++++");

        new Thread(() -> System.out.println("yeah yeah yeah")).start();

        System.out.println("+++++++++++++++++++++++");

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(string -> System.out.println(string.toUpperCase()));

        System.out.println("+++++++++++++++++++++++");

        List<String> list2 = new ArrayList<>();
        list.forEach(string -> list2.add(string.toUpperCase()));
        list2.forEach(string -> System.out.println(string));

        System.out.println("+++++++++++++++++++++++");

        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface Test3Interface {
    void myMethod();
}

@FunctionalInterface
interface Test3Interface2 {
    void myMethod2();
}
