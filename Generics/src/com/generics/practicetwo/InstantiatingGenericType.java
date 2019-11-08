package com.generics.practicetwo;

import java.util.function.Supplier;

//Instantiating a generic type
public class InstantiatingGenericType {

    public <T> void genericMethod(){
       // T t = new T();
        //can not instantiate the type T. type T erased. the JVM doesn't know what T originally was, it doesn't know which to call
    }

    public static <T>  void genericMethodm(Class<T> cls){//one way
        try{
            T t = cls.newInstance();
            System.out.println("instance created");
        }catch (InstantiationException | IllegalAccessException e){
            System.err.println("Could not instantiate: "+cls.getName());
        }
    }

    public static  <T> void genericMethodd(Supplier<T> cons){//another way
        T t = cons.get();
        System.out.println("created");
    }

    public static void main(String[] args) {
        genericMethodm(String.class);
        genericMethodd(String::new);
    }

}
