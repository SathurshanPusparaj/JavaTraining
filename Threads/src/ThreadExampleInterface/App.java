package ThreadExampleInterface;



public class App {

    public static void main(String[] args) {
        Printer p = new Printer();

        //8 ways of creating thread

        System.out.println("Main Priority before "+Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(10);
        Thread thread = new Thread(p);
        thread.setPriority(10);

        System.out.println("Main Priority after"+Thread.currentThread().getPriority());
        System.out.println("child Priority "+thread.getPriority());

        thread.start();
        //Thread thread1 = new Thread();
        //Thread thread2 = new Thread("ff");
        //Thread thread3 = new Thread(new ThreadGroup(),"ff");
        //Thread thread4 = new Thread(new ThreadGroup(),p);
        //Thread thread4 = new Thread(new ThreadGroup(),p,"fff");
        //Thread thread4 = new Thread(new ThreadGroup(),p,"fff",stacksize);

        for(int i=0;i<10;i++){
            System.out.println("Main Thread"+Thread.currentThread().getName()+" "+i);
        }
        System.out.println("============");
    }
}
