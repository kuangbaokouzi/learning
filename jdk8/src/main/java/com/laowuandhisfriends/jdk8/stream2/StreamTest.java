package com.laowuandhisfriends.jdk8.stream2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamTest {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 90);
        Student s2 = new Student("lisi", 80);
        Student s3 = new Student("wangwu", 85);
        Student s4 = new Student("zhangsan", 80);
        Student s5 = new Student("wangwu", 85);

        List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        Collector<Student, ?, HashSet<Student>> intoSet =
                Collector.of(HashSet::new, HashSet::add, (left, right) -> {
                    left.addAll(right);
                    return left;
                });
        HashSet<Student> hashSet = list.stream().collect(intoSet);
        hashSet.forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        list.stream().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        list.stream().collect(minBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        list.stream().collect(maxBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);

        System.out.println("+++++++++++++++++++++++");

        System.out.println(list.stream().collect(averagingDouble(Student::getScore)));

        System.out.println("+++++++++++++++++++++++");

        System.out.println(list.stream().collect(summingInt(Student::getScore)));

        System.out.println("+++++++++++++++++++++++");

        System.out.println(list.stream().collect(summarizingInt(Student::getScore)));

        System.out.println("+++++++++++++++++++++++");

        System.out.println(list.stream().map(Student::getName).collect(joining()));
        System.out.println(list.stream().map(Student::getName).collect(joining(", ")));
        System.out.println(list.stream().map(Student::getName).collect(joining(",", "[", "]")));

        System.out.println("+++++++++++++++++++++++");

        Map<Integer, Map<String, List<Student>>> map =
                list.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        map.forEach((k, v) -> System.out.println(k + "=" + v));

        System.out.println("+++++++++++++++++++++++");

        Map<Boolean, List<Student>> map2 =
                list.stream().collect(partitioningBy(student -> student.getScore() > 80));
        map2.forEach((k, v) -> System.out.println(k + "=" + v));

        System.out.println("+++++++++++++++++++++++");

        Map<Boolean, Map<Boolean, List<Student>>> map3 = list.stream().collect(
                partitioningBy(student -> student.getScore() > 80, partitioningBy(stu2 -> stu2.getScore() > 85)));
        map3.forEach((k, v) -> System.out.println(k + "=" + v));

        System.out.println("+++++++++++++++++++++++");

        Map<Boolean, Long> map4 =
                list.stream().collect(partitioningBy(student -> student.getScore() > 80, counting()));
        map4.forEach((k, v) -> System.out.println(k + "=" + v));

        System.out.println("+++++++++++++++++++++++");

        Map<String, Student> map5 = list.stream().collect(groupingBy(Student::getName,
                collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        map5.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
