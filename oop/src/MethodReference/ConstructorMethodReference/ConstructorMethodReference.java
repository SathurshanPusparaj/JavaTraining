package MethodReference.ConstructorMethodReference;

interface Messagable{
    void getmessage(String msg);
}

class Message{
    Message(String msg){
        System.out.println(msg);
    }
}

public class ConstructorMethodReference {
    public static void main(String[] args) {
        Messagable messagable = Message::new;
        messagable.getmessage("This is constructor method reference");
    }

}
