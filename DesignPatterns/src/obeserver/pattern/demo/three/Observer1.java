package obeserver.pattern.demo.three;

public class Observer1 implements IObservers {
    @Override
    public void update(String subjectname, int i) {
        System.out.println("I am Observer, the subject is "+subjectname+" update value:"+i);
    }
}
