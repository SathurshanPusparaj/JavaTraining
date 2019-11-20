package obeserver.pattern.demo.two;

import obeserver.pattern.demo.two.IObserver;

public interface ISubject {
    int getFlag();
    void setFlag(int flag);
    void register(IObserver o);
    void unregister(IObserver o);
    void notifyObserver(int i);
}
