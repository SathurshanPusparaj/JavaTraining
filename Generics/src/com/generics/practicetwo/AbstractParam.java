package com.generics.practicetwo;

public abstract class AbstractParam<T> { //abstract class generics

    private T value;

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }
}

class Height<T> extends AbstractParam<T>{
    public static void main(String[] args) {
        Height<Integer> height = new Height<>();
        height.setValue(165);
        System.out.println("Height: "+height.getValue());

        AbstractParam<Double> newHeight = new AbstractParam<Double>(){};//why {} because abstract use when the class have half implementation
        newHeight.setValue(170.00);
        System.out.println(newHeight.getValue());
    }
}