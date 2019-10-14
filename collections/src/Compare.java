import java.util.Comparator;

public class Compare implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getId()>s1.getId()){
            return +1;
        }else if(s1.getId()<s2.getId()){
            return -1;
        }else{
            return 0;
        }
    }
}