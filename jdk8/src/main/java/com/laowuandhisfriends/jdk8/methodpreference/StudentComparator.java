package com.laowuandhisfriends.jdk8.methodpreference;

public class StudentComparator {
    public int compareByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compareByName(Student s1, Student s2) {
        return s2.getName().compareTo(s1.getName());
    }
}
