package MethodReference.InstanceMethodReference;

interface Sayable{
    void say();
}

public class InstanceMethodReference {

    public void saysomething(){
        System.out.println("this is a non-static method");
    }

    public static void main(String[] args) {
        InstanceMethodReference imr= new InstanceMethodReference();
        Sayable sayable = imr::saysomething;
        sayable.say();

        Sayable sayable1 = new InstanceMethodReference()::saysomething;
        sayable1.say();

    }
}
