package com.laowuandhisfriends.jdk8.methodpreference;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 90);
        Student s3 = new Student("wangwu", 50);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> list = Arrays.asList(s1, s2, s3, s4);

        //list.sort((param1, param2) -> Student.compareStudentByScore(param1, param2));
        list.sort(Student::compareStudentByScore);
        System.out.println(list);
        list.sort(Student::compareStudentByName);
        System.out.println(list);
    }
}
