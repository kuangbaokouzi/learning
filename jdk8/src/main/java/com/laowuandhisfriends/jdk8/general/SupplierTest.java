package com.laowuandhisfriends.jdk8.general;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello world";
        System.out.println(stringSupplier.get());
        System.out.println("+++++++++++++");
        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get());
        System.out.println("+++++++++++++");
        Supplier<Student> studentSupplier2 = Student::new;
        System.out.println(studentSupplier2.get());
        System.out.println("+++++++++++++");
        Supplier<Student> studentSupplier3 = Student::new;
        System.out.println(studentSupplier3.get());
        System.out.println("+++++++++++++");
        BiFunction<String, Integer, Student> biFunction = (v1, v2) -> new Student(v1, v2);
        System.out.println(biFunction.apply("lisi", 99));
        System.out.println("+++++++++++++");
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.apply(1, 2));
        System.out.println("+++++++++++++");
        Comparator<String> comparator = (c1, c2) -> c1.compareTo(c2);
        System.out.println(comparator.compare("abc", "abd"));
        System.out.println("+++++++++++++");
        System.out.println(getMin("hello ", "world", (a, b) -> a.length() - b.length()));
        System.out.println("+++++++++++++");
        System.out.println(getMin("hello", "world", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    public static String getMin(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
