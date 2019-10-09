package com.dox.springdatajpaexample.Service;

import com.dox.springdatajpaexample.modal.Student;

import java.util.List;
import java.util.Optional;

public interface ServiceInf {
    public Student save(Student s);

    public List<Student> getAllStudents();

    public Optional<Student> getStudent(int id);
}
