package com.laowuandhisfriends.jdk8.defaultmethod;

public class MyInterfaceImpl2 extends MyInterfaceImpl implements MyInterface2 {
    public static void main(String[] args) {
        MyInterfaceImpl2 myInterfaceImpl2 = new MyInterfaceImpl2();
        myInterfaceImpl2.myMethod();
    }
}
