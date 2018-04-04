package com.laowuandhisfriends.jdk8.stream;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }

        System.out.println("sorting begin: ");
        long startTime = System.nanoTime();

//        list.stream().sorted().count();
        list.parallelStream().sorted().count();

        long endTime = System.nanoTime();

        long cost = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("sorting costs: " + cost);


    }
}
