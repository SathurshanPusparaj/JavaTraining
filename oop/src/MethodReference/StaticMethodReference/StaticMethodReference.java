package MethodReference.StaticMethodReference;

interface Printable{
    void show();
}

public class StaticMethodReference {// Refering to a static method

    static void showable(){
        System.out.println("This is implicit class");
    }

    public static void main(String[] args) {
        Printable printable = StaticMethodReference::showable;
        printable.show();
    }


}
