package com.laowuandhisfriends.jdk8;

@FunctionalInterface
interface MyInterface {
    void test();

    String toString();
}

public class Test2 {

    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("myTest");
            }
        });
        System.out.println("++++++++++++++++++++");
        test2.myTest(() -> {
            System.out.println("myTest");
        });
        System.out.println("++++++++++++++++++++");
        MyInterface myInterface = () -> {
            System.out.println("myTest");
        };
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
        test2.myTest(myInterface);
    }
}
