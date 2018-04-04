package com.laowuandhisfriends.jdk8.general;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // output all even
        conditionFilter(list, item -> item % 2 == 0);
        System.out.println("++++++++++++++++++");
        // output all odd
        conditionFilter(list, item -> item % 2 == 1);
        System.out.println("++++++++++++++++++");
        // output all items gt 5
        conditionFilter(list, item -> item > 5);
        System.out.println("++++++++++++++++++");
        // output all items
        conditionFilter(list, item -> true);
        System.out.println("++++++++++++++++++");
        // output none
        conditionFilter(list, item -> false);
        System.out.println("++++++++++++++++++");
        conditionFilter(list, item -> item % 2 == 0, item -> item > 5);
        System.out.println("++++++++++++++++++");
        System.out.println(Predicate.isEqual("test").test("test"));
    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(integer -> {
            if (predicate.test(integer))
                System.out.print(integer + " ");
        });
        System.out.println();
    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate,
                                       Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate.and(predicate2).negate().test(integer))
                System.out.print(integer + " ");
        });
        System.out.println();
    }
}
