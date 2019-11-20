package obeserver.pattern.demo.two;

public class Observer2 implements IObserver {
    @Override
    public void update(int i) {
        System.out.println("I am Observer2, my subject value is:"+i);
    }
}
