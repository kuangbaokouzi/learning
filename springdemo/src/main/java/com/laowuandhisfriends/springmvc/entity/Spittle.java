package com.laowuandhisfriends.springmvc.entity;


import java.util.Date;

public class Spittle {
    private Spitter spitter;
    private String text;
    private Date when;

    public Spittle() {
    }

    public Spittle(Spitter spitter, String text, Date when) {
        this.spitter = spitter;
        this.text = text;
        this.when = when;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }
}
