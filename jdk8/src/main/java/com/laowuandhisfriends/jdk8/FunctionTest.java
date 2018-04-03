package com.laowuandhisfriends.jdk8;

import java.util.function.Function;

public class FunctionTest {
    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute(1, value -> {
            return 2 * value;
        }));
        System.out.println(functionTest.compute(2, value -> 5 + value));
        System.out.println(functionTest.compute(3, value -> value + value));
        System.out.println(functionTest.convert(4, value -> String.valueOf(value) + 4));
    }
}
