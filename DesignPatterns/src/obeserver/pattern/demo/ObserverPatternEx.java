package obeserver.pattern.demo;

import java.util.ArrayList;
import java.util.List;

class Observer{
    public void update(){
        System.out.println("flag value changed in Subject");
    }
}

interface ISubject{
    int getFlag();
    void setFlag(int flag);
    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();
}

class Subject implements ISubject{

    List<Observer> observerList = new ArrayList<>();

    private int flag;

    public int getFlag(){
        return flag;
    }

    public void setFlag(int flag){
        this.flag=flag;
        notifyObserver();
    }

    @Override
    public void register(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer:observerList){
            observer.update();
        }
    }
}


public class ObserverPatternEx {

    public static void main(String[] args) {
        System.out.println("****Observer Pattern Demo****");
        Observer o1 = new Observer();
        ISubject iSubject = new Subject();
        iSubject.register(o1);
        iSubject.setFlag(5);
        iSubject.setFlag(25);
        iSubject.unregister(o1);
        //No notification this time o1. unregistered
        System.out.println("Setting Flag = 50");
        iSubject.setFlag(50);
    }

}
