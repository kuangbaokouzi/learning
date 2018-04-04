package com.laowuandhisfriends.jdk8.methodpreference;

import java.util.Arrays;
import java.util.List;

public class StudentTest2 {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        StudentComparator studentComparator = new StudentComparator();
        list.sort(studentComparator::compareByScore);
        System.out.println(list);
        list.sort(studentComparator::compareByName);
        System.out.println(list);
    }
}
