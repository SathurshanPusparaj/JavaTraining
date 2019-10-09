import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    static void printStudentsWithShortnames(){
        List<Student> students = Student.getStudent();
        for(Student student:students){
            if(student.getName().length()<=6){
                System.out.println(student.getName());
            }
        }
    }

    static void process(){
       // List<Student> students = Student.getStudent().stream().map(s->new Student("Dr."+s.getName(),s.getId())).collect(Collectors.toList());
       // System.out.println(students);
        System.out.println("-----Processing-----");
        Student.getStudent().stream().map(s->new Student("Dr."+s.getName(),s.getId())).collect(Collectors.toList()).forEach(s-> System.out.println(s.getName()));
    }

    static void filterWithStream(){
        System.out.println("-----Filtering-----");
        List<Student> students = Student.getStudent().stream().filter(s->s.getName().length()<=6).collect(Collectors.toList());
        System.out.println(students.toString());
    }

    public static void main(String[] args) {
        printStudentsWithShortnames();
        filterWithStream();
        process();
    }
}
