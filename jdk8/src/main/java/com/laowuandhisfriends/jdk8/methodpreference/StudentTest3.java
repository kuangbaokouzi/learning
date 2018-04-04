package com.laowuandhisfriends.jdk8.methodpreference;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class StudentTest3 {

    public static String getString(Supplier<String> stringSupplier) {
        return stringSupplier.get() + "test";
    }

    public static String getString(String a, Function<String, String> function) {
        return function.apply(a + " test");
    }

    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        list.sort(Student::compareByScore);
        System.out.println(list);
        list.sort(Student::compareByName);
        System.out.println(list);

        // System.out.println(getString(() -> new String()));
        System.out.println(getString(String::new));
        // System.out.println(getString("hello", string -> new String(string)));
        System.out.println(getString("hello", String::new));
    }
}
