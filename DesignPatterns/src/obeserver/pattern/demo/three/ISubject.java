package obeserver.pattern.demo.three;

public interface ISubject {
    int getFlag();
    void setFlag(int flag);
    void register(IObservers o);
    void unregister(IObservers o);
    void notifyObserver(int i);
}
