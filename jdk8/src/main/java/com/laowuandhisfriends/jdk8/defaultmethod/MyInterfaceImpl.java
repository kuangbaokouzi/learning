package com.laowuandhisfriends.jdk8.defaultmethod;

public class MyInterfaceImpl implements MyInterface, MyInterface2 {

    @Override
    public void myMethod() {
        MyInterface.super.myMethod();
    }

    public static void main(String[] args) {
        MyInterfaceImpl myInterface = new MyInterfaceImpl();
        myInterface.myMethod();
    }
}
