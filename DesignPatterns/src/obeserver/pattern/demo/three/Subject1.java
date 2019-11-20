package obeserver.pattern.demo.three;

import java.util.ArrayList;
import java.util.List;

public class Subject1 implements ISubject {

    private int value;
    private List<IObservers> observers = new ArrayList<>();

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
    public void register(IObservers o) {
        System.out.println("Observer has been added");
        observers.add(o);
    }

    @Override
    public void unregister(IObservers o) {
        System.out.println("Observer has been removed");
        observers.remove(o);
    }

    @Override
    public void notifyObserver(int i) {
        for(IObservers observer:observers){
            observer.update(this.getClass().getSimpleName(),i);
        }
    }
}
