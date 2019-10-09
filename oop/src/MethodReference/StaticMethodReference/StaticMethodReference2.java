package MethodReference.StaticMethodReference;

public class StaticMethodReference2 {
    public static void RunningStatus(){
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(StaticMethodReference2::RunningStatus);
        t1.start();
    }
}
