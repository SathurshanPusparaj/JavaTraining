package com.dox.springdatajpaexample.modal;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name="project_student",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> students;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setName(String name) {
        this.name = name;
    }
}
