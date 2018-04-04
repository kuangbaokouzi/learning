package com.laowuandhisfriends.jdk8.defaultmethod;

public interface MyInterface {
    default void myMethod() {
        System.out.println("MyInterface");
    }
}
