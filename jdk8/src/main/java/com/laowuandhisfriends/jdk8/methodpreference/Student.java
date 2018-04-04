package com.laowuandhisfriends.jdk8.methodpreference;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static int compareStudentByScore(Student s1, Student s2) {
        return s1.score - s2.score;
    }

    public static int compareStudentByName(Student s1, Student s2) {
        return s2.name.compareTo(s1.name);
    }

    public int compareByScore(Student s) {
        return this.score - s.score;
    }

    public int compareByName(Student s) {
        return s.name.compareTo(this.name);
    }
}
