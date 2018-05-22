package com.entor.mybatisdemo.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private Integer id;
    private String sname;
    private  Integer age;
    private Integer sex;
    // 一对多，每个human都可能拥有多台汽车
    private List<Car> cars = new ArrayList<>();

    public Human() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", cars=" + cars +
                '}';
    }
}
