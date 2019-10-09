import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Student> students = Student.getStudent();
        System.out.println(students);

        Collections.sort(students,new ComapareImp());
        System.out.println(students);

    }
}
