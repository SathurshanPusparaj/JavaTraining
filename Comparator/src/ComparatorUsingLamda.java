import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsingLamda {
    public static void main(String[] args) {

        System.out.println("---Unsorted List---");
        List<Student> sortedStudents = Student.getStudent();
        System.out.println(sortedStudents);

        System.out.println("---Sorted in Ascending order---");
        Comparator<Student> studentComparator = Comparator.comparing(Student::getId);
        Collections.sort(sortedStudents,studentComparator);
        System.out.println(sortedStudents);

        System.out.println("---Sorted in Descending order---");
        studentComparator = Comparator.comparing(Student::getId).reversed();
        Collections.sort(sortedStudents,studentComparator);
        System.out.println(sortedStudents);
    }
}
