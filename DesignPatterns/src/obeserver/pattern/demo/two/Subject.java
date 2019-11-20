package obeserver.pattern.demo.two;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
    private int value;
    private List<IObserver> observers = new ArrayList<>();

    @Override
    public int getFlag() {
        return value;
    }

    @Override
    public void setFlag(int flag) {
        this.value = flag;
        notifyObserver(flag);
    }

    @Override
    public void register(IObserver o) {
        System.out.println("Observer added");
        observers.add(o);
    }

    @Override
    public void unregister(IObserver o) {
        System.out.println("Observer removed");
        observers.remove(o);
    }

    @Override
    public void notifyObserver(int i) {
        for(IObserver ob:observers){
            ob.update(i);
        }
    }
}
