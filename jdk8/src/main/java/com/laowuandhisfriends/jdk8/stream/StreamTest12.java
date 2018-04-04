package com.laowuandhisfriends.jdk8.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest12 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 20, 90);
        Student s2 = new Student("lisi", 21, 80);
        Student s3 = new Student("wangwu", 19, 85);
        Student s4 = new Student("zhangsan", 22, 70);

        Stream<Student> studentStream = Stream.of(s1, s2, s3, s4);
        Map<String, List<Student>> map = studentStream.collect(Collectors.groupingBy(Student::getName));
        map.forEach((k, v) -> System.out.println(v));

        System.out.println("++++++++++++++");

        studentStream = Stream.of(s1, s2, s3, s4);
        Map<String, Long> map2 = studentStream.collect(Collectors.groupingBy(Student::getName,
                Collectors.counting()));
        map2.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("++++++++++++++");

        studentStream = Stream.of(s1, s2, s3, s4);
        Map<String, Double> map3 = studentStream.collect(Collectors.groupingBy(Student::getName,
                Collectors.averagingDouble(Student::getScore)));
        map3.forEach((k, v) -> System.out.println(k + ":" + v));

        System.out.println("++++++++++++++");

        studentStream = Stream.of(s1, s2, s3, s4);
        Map<Boolean, List<Student>> map4 = studentStream.collect(
                Collectors.partitioningBy(student -> student.getScore() >= 80));
        map4.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
