package obeserver.pattern.demo.two;


public class Observer1 implements IObserver {
    @Override
    public void update(int i) {
        System.out.println("I am Observer1, My value in Subject is:"+i);
    }
}
