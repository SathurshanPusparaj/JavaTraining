package com.generics.practicetwo;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

abstract class Animal{
    public abstract String getSound();
}

class Cat extends Animal{

    @Override
    public String getSound() {
        return "Meow";
    }
}

class Dog extends Animal{

    @Override
    public String getSound() {
        return "Woof";
    }
}

class UnboundedGenericAnimalContainer<T>{
    private Collection<T> col;

    public unboundedGenericAnimalContainer(){
        col = new ArrayList<>();
    }

    public void add(T t){
        col.add(t);
    }
    public void printAllSounds(){
        for(T t:col){
            //Illegal , type T doesn't makeSound()
            //it is used as an java.lang.object
           // System.out.println(t.getSound());
        }
    }

}

class BoundedGenericAnimalContainer<T extends Animal>{
    private Collection<T> col;

    public BoundedGenericAnimalContainer(){
        col = new ArrayList<>();
    }

    public void add(T t){
        col.add(t);
    }
    public void printAllSounds(){
        for(T t:col){
            System.out.println(t.getSound());
        }
    }

}

public class BoundedGenericClass {
    public static void main(String[] args) {
        UnboundedGenericAnimalContainer<Cat> unbounded = new UnboundedGenericAnimalContainer<Cat>();

        BoundedGenericAnimalContainer<Cat> bounded = new BoundedGenericAnimalContainer<>();
        //BoundedGenericAnimalContainer<String> b = new BoundedGenericAnimalContainer<String>();
       //Illegal because String doesn't extends Animal

    }
}
