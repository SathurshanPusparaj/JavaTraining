package ThreadExampleInheritance;

public class Printer extends Thread {
    /*@Override
    public synchronized void start() {// you can able to override the start method but the it stops the thread creation
        System.out.println("This is start method");
    }*/

    @Override
    public synchronized void start() {// now it create new thread
        super.start();
        System.out.println("This is start method");
    }

    @Override
    public void run() {
        for(int i=0;i<200;i++){
            System.out.println(i);
        }
    }

    public void run(int x) {//overload works but start() only invoke run()[no args]
        for(int i=0;i<200;i++){
            System.out.println(i);
        }
    }


}
