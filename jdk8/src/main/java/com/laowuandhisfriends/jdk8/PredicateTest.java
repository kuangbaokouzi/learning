package com.laowuandhisfriends.jdk8;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = person -> person.length() > 5;
        System.out.println(predicate.test("123"));
    }
}
