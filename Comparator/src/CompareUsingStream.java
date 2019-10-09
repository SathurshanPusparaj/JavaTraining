import java.util.List;
import java.util.stream.Collectors;

public class CompareUsingStream {
    public static void main(String[] args) {
        System.out.println("---Unsorted List---");
        List<Student> students = Student.getStudent();
        System.out.println(students);

        System.out.println("---Sorted in Ascending order---");
        students = Student.getStudent().stream().sorted((s1,s2)->new Integer(s1.getId()).
                compareTo(s2.getId())).collect(Collectors.toList());
        System.out.println(students);

        System.out.println("---Sorted in Descending order---");
        students = Student.getStudent().stream().sorted((s1,s2)->new Integer(-s1.getId()).
                compareTo(-s2.getId())).collect(Collectors.toList());
        System.out.println(students);

    }
}

