package OOP;

interface GFG{
    void myMethod();
    void getInfo();
}

abstract class Geeks implements GFG{

    void getData(){
        System.out.println("GFG");
    }
}

public class Test extends Geeks {

    @Override
    public void myMethod() {
        System.out.println("GeeksForGeeks");
    }

    @Override
    public void getInfo() {
        System.out.println("Geeks-Test");
    }

    public static void main(String[] args) {
        Geeks geeks = new Test();
        geeks.getInfo();//It check Geeks class as method signature
    }
}
