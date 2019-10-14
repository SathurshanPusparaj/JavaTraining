import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionApp {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Finnegan");
        list.add("Cortez");
        list.add("Luciano");
        list.add("Nickolas");
        list.add("Darren");
        list.add("Jonah");
        list.add("Rylee");
        list.add("Jayvon");
        list.add("Jaxson");
        list.add("Heath");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);


        List<Student> students = new ArrayList<>();
        students.add(new Student(5,"harry","melbourne"));
        students.add(new Student(8,"rone","newyork"));
        students.add(new Student(2,"spenser","london"));
        students.add(new Student(10,"walker","texas"));
        students.add(new Student(1,"marina","san fransico"));
        students.add(new Student(6,"johnson","chicago"));
        students.add(new Student(4,"tony","seatle"));
        students.add(new Student(9,"thanos","washington"));
        students.add(new Student(3,"chris","austin"));
        students.add(new Student(7,"emsworth","las vegas"));

        for(Student student:students){
            System.out.println(student.toString());
        }

        //Collections.sort(students,new Compare());
        System.out.println("---------------------------------");
        Collections.sort(students);

        for(Student student:students){
            System.out.println(student.toString());
        }

    }
}
