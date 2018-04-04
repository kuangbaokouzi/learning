package com.laowuandhisfriends.jdk8.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setName("zhangsan");
        Emp emp2 = new Emp();
        emp2.setName("lisi");

        Company company = new Company();
        company.setName("java");
        company.setEmps(Arrays.asList(emp, emp2));

        Optional<Company> optionalCompany = Optional.of(company);
        System.out.println(optionalCompany.map(com -> com.getEmps()).orElse(Collections.emptyList()));
    }
}
