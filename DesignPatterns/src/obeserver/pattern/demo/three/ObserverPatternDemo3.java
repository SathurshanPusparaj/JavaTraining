package obeserver.pattern.demo.three;

public class ObserverPatternDemo3 {
    public static void main(String[] args) {
        ISubject sub1 = new Subject1();
        ISubject sub2 = new Subject2();

        IObservers obs1 = new Observer1();
        IObservers obs2 = new Observer2();

        sub1.register(obs1);
        sub1.register(obs2);

        sub2.register(obs1);

        sub1.setFlag(650);

        sub2.setFlag(500);

    }
}
