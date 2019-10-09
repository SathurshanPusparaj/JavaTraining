package ThreadExampleInheritance;

public class Application {
    public static void main(String[] args) {
        Printer p = new Printer();
       // p.run(); //execute directly from main thread without creating new thread
        p.setDaemon(true);
        p.start();//Generate a new thread

        for(int i=0;i<10;i++){
            System.out.println("Main Thread"+Thread.currentThread().getName()+" "+i);
        }
        System.out.println("============");
    }
}
