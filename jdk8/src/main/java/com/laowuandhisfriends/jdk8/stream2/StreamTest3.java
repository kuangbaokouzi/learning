package com.laowuandhisfriends.jdk8.stream2;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("auto close invoked!");
    }

    public void doSomething() {
        System.out.println("do something!");
    }

    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        list.stream().collect(new MyCollector<>()).forEach(System.out::println);

        System.out.println("++++++++++++++++");

        for (int i = 0; i < 1000; i++) {
//            list.parallelStream().collect(new MyCollector2<>()).forEach((k, v) -> System.out.println(k + "=" + v));
            list.stream().collect(new MyCollector2<>()).forEach((k, v) -> System.out.println(k + "=" + v));
        }

        try (StreamTest3 test3 = new StreamTest3()) {
            test3.doSomething();
        }
    }
}
