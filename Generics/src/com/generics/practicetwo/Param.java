package com.generics.practicetwo;

public class Param<T> { //basic generics

    private T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Param<Integer> integerParam  = new Param<>();
        integerParam.setValue(10);
        System.out.println(integerParam.getValue());

        //other complex reference types
        /*Param<String[]> stringParam;
        Param<int[][]> int2dArray;
        Param<Param<Object>> objectNestedParam;*/



    }
}
