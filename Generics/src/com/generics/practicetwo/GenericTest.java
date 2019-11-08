package com.generics.practicetwo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Shoe{}
class IPhone{}
interface Fruit{}
class Apple implements Fruit{}
class Banana implements Fruit{}
class Grannysmith extends Apple{}


//WORKING WITH Java generics bounded wild cards
class FruitHelper{

    //upper bounded wildcard
    public void eatAll(Collection<? extends Fruit> fruits){} //represent a type that must be a subtype of Fruit(T) ---only need read access---

    //lower bounded wildcard
    public void addApple(Collection<? super Apple> apples){} //represent a type that must be a supertype of Apple(T) ---only need write access---
}

public class GenericTest {

    public static <T extends Apple> void used(Collection<T> value){ //ratherthan putting bound in parameters make the method into generic[generic methods]
        System.out.println("----bounding-------");
    }
    //override this type inference with explicit type[page number 270]

    public static <T extends Number & Comparable<T>> void sortNumbers(List<T> n){
        Collections.sort(n);
    }
//multiple inheritance not allowed, you canuse at most one class as a bound and it listed first [ you cannot extends the comparable interface]

    public static void main(String[] args) {
        FruitHelper fruitHelper = new FruitHelper();
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Banana());
        fruitHelper.addApple(fruits);
        fruitHelper.eatAll(fruits);

        Collection<Banana> bananas = new ArrayList<>();
        bananas.add(new Banana());
        fruitHelper.eatAll(bananas);
        //fruitHelper.addApple(bananas); because banana is not a super type of Apple. it is subtype of Fruit

        Collection<Apple> apples = new ArrayList<>();
        apples.add(new Grannysmith());
        fruitHelper.addApple(apples);
        fruitHelper.addApple(apples);

        Collection<Grannysmith> grannysmithsApples = new ArrayList<>();
        //fruitHelper.addApple(grannysmithsApples); Granny is a super type of apple compilation error
        apples.add(new Grannysmith());
        fruitHelper.eatAll(grannysmithsApples);//granny smith is a Fruit

        Collection<Object> objects = new ArrayList<>();
        fruitHelper.addApple(objects);
        //fruitHelper.eatAll(objects); it only allows the subtype of Fruits
        objects.add(new Shoe());

        used(grannysmithsApples);
        //used(bananas);

        List<Integer> ls = new ArrayList<>();
        List<AtomicInteger> nls = new ArrayList<>();

        sortNumbers(ls);
        //sortNumbers(nls); AtomicInteger doesn't implements the comparable interface

    }
}
