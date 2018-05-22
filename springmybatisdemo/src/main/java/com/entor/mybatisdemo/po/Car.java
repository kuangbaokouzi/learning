package com.entor.mybatisdemo.po;

import java.io.Serializable;

public class Car implements Serializable {
    private Integer id;
    private String mark;
    private Double price;
    // 一对一，一辆汽车只属于一个人
    private Human human;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
