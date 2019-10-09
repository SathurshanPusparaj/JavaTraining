package exercise2;

public class Lamdaprinter {
    public static void main(String[] args) {
        Printer p = () -> System.out.println("This is using Lamda Expression");
        p.print();
    }
}
