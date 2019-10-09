import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private int id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int id){
        this.name=name;
        this.id=id;
    }

    public static List<Student> getStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("krish",1));
        students.add(new Student("dinoth",2));
        students.add(new Student("Hansini",11));
        students.add(new Student("viraj",12));
        students.add(new Student("Nuwan",21));
        students.add(new Student("Kulesekara",22));
        students.add(new Student("Raj",31));

        return students;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
