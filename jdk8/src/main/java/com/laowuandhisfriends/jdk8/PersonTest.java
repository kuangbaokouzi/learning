package com.laowuandhisfriends.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi", 30);
        Person p3 = new Person("wangwu", 40);

        List<Person> list = Arrays.asList(p1, p2, p3);

        System.out.println(getPersonByUsername("zhangsan", list));
        System.out.println("+++++++++++++");
        System.out.println(getPersonByAge(20, list));
        System.out.println("+++++++++++++");
        System.out.println(getPersonByAge2(20, list, (age, persons) -> persons.stream()
                .filter(person -> age < person.getAge()).collect(Collectors.toList())));
        System.out.println("+++++++++++++");
        System.out.println(getPersonByAge2(20, list, (age, persons) -> persons.stream()
                .filter(person -> age >= person.getAge()).collect(Collectors.toList())));

    }

    public static List<Person> getPersonByUsername(String username, List<Person> persons) {
        return persons.stream().filter(person -> username.equals(person.getUsername()))
                .collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(Integer age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (ageOfPerson, personList) ->
                personList.stream().filter(person -> ageOfPerson < person.getAge())
                        .collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    public static List<Person> getPersonByAge2(Integer age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, persons);
    }
}
