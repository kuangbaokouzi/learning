package com.laowuandhisfriends.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("hello", "world", "welcome");
        // String[] strings = stringStream.toArray(length -> new String[length]);
        String[] strings = stringStream.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        System.out.println("+++++++++++++");

        stringStream = Stream.of("hello", "world", "welcome");
        // List<String> list = stringStream.collect(Collectors.toList());
//        List<String> list = stringStream.collect(() -> new ArrayList<>(),
//                (theList, item) -> theList.add(item), (result, theList) -> result.addAll(theList));
        List<String> list = stringStream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println(list);

        System.out.println("+++++++++++++");

        stringStream = Stream.of("hello", "world", "welcome");
        System.out.println(stringStream.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append).toString());

        System.out.println("+++++++++++++");
        stringStream = Stream.of("hello", "world", "welcome");
        stringStream.collect(Collectors.toCollection(LinkedList::new)).forEach(System.out::println);

        System.out.println("+++++++++++++");
        Stream.of("hello", "world", "welcome").collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("+++++++++++++");
        Stream.of("hello", "world", "welcome").collect(Collectors.toCollection(TreeSet::new))
                .forEach(System.out::println);

        System.out.println("+++++++++++++");
        String string = Stream.of("hello", "world", "welcome").collect(Collectors.joining()).toString();
        System.out.println(string);
    }
}
