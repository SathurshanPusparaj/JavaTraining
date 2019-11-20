package obeserver.pattern.demo.two;


public class ObserverPatternModified {
    public static void main(String[] args) {
        ISubject sub = new Subject();

        IObserver observer1 = new Observer1();
        IObserver observer2 = new Observer2();

        sub.register(observer1);
        sub.register(observer2);
        sub.setFlag(50);
        sub.unregister(observer2);
        sub.setFlag(20);

    }
}
