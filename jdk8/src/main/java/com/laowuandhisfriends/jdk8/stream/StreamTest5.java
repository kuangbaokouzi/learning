package com.laowuandhisfriends.jdk8.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.generate(UUID.randomUUID()::toString);
        stringStream.findFirst().ifPresent(System.out::println);

        System.out.println("++++++++++++");

        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);

        System.out.println("++++++++++++");

        System.out.println(Stream.iterate(1, item -> item + 2).limit(6)
                .filter(integer -> integer > 2).skip(2)
                .mapToInt(integer -> integer * 2).limit(2).sum());

        System.out.println("++++++++++++");

        Stream.iterate(1, item -> item + 2).limit(6)
                .filter(integer -> integer > 2).skip(2)
                .mapToInt(integer -> integer * 2).limit(2).max().ifPresent(System.out::println);
        System.out.println("++++++++++++");

        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(integer -> integer > 2).skip(2)
                .mapToInt(integer -> integer * 2).limit(2).summaryStatistics();
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getCount());

        System.out.println("++++++++++++");


    }
}
