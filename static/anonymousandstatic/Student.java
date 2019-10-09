public class Student {
    Student(){
        System.out.println("Student Constructor");
    }
    static {
        System.out.println("Static block");
    }
    {
        System.out.println("Anonymous method");
    }
    void print(String x){
        System.out.println("Print Method.Value:"+x);
    }
}
