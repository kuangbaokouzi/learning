package com.laowuandhisfriends.jdk8.general;

import java.util.*;

public class StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(names);

        System.out.println("++++++++++++++++++++++");

        Collections.sort(names, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(names);
    }
}
