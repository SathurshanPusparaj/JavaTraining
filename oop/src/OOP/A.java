package OOP;

public class A {
    public void showA(){
        System.out.println("THis is A");
    }
}

class B extends A{

    @Override
    public void showA() {
        System.out.println("This B");
    }

    public void showB(){
        System.out.println("THis is B");
    }
}
class C{
    public static void main(String[] args) {
        A ab=new B();// Upcasting
        ab.showA();

        B b = (B)ab;//downcasting
        b.showB();
    }
}