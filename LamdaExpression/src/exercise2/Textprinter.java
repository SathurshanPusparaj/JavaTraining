package exercise2;

public class Textprinter{

    public static void main(String[] args) {
        Printer p = new Printer() {
            @Override
            public void print() {
                System.out.println("Executed using Anonymous inner class");
            }
        };

        p.print();

       // Printer p = () -> System.out.println("hi");
        //p.print();

    }
}
