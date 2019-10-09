import java.util.Comparator;
import java.util.Optional;

public class Filterstreams {

    static void countFilter(){
        long count = Student.getStudent().stream().count();
        System.out.println("Number of elements: "+count);
    }
    static void minfilter(){
       String student = Student.getStudent().stream().min(Comparator.comparing(s-> s.getId())).get().getName();
       System.out.println("min value :"+student);
    }
    static void maxfilter(){
        Optional<Student> student = Student.getStudent().stream().max(Comparator.comparingInt(s->s.getId()));
        System.out.println("Max: "+student);
    }
    public static void main(String[] args) {
        countFilter();
        minfilter();
        maxfilter();
    }
}
