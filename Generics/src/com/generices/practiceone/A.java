package com.generices.practiceone;

public class A {
    public void method(){
        System.out.println("class A");
    }
}

class B extends A{
    public void dev(){
        System.out.println("class B");
    }
}

class C{
    public static void main(String[] args) {


        A a = new B();
        a.method();
    }
}