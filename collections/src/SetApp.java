import java.util.HashSet;
import java.util.Set;

public class SetApp {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student(5,"harry","melbourne"));
        students.add(new Student(8,"rone","newyork"));
        students.add(new Student(2,"spenser","london"));
        students.add(new Student(8,"rone","newyork"));
        students.add(new Student(1,"marina","san fransico"));

        for(Student student:students){
            System.out.println(student.toString());
        }

    }

}
