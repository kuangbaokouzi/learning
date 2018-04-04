package com.laowuandhisfriends.jdk8.general;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 test2 = new FunctionTest2();
        System.out.println(test2.compute(2, value -> value * 3, value -> value * value));
        System.out.println(test2.compute2(2, value -> value * 3, value -> value * value));
        System.out.println("++++++++++++");
        System.out.println(test2.compute3(1, 2, (v1, v2) -> v1 + v2));
        System.out.println(test2.compute3(1, 2, (v1, v2) -> v1 - v2));
        System.out.println("++++++++++++");
        System.out.println(test2.compute4(1, 2, (v1, v2) -> v1 + v2, v3 -> v3 * v3));

    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                        Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
