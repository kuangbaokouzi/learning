package com.laowuandhisfriends.jdk8.general;

import java.util.List;

public class Company {
    private String name;
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
