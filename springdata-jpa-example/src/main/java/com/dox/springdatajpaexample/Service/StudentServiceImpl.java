package com.dox.springdatajpaexample.Service;

import com.dox.springdatajpaexample.modal.Student;
import com.dox.springdatajpaexample.modal.Telephone;
import com.dox.springdatajpaexample.repository.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements ServiceInf{

    @Autowired
    RepositoryImpl repository;

    @Override
    public Student save(Student s) {

        for(Telephone telephone:s.getTelephones()){
            telephone.setStudent(s);
        }

        repository.save(s);
        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = repository.findAll();
        return students;
    }

    @Override
    public Optional<Student> getStudent(int id) {
        Optional<Student> s = repository.findById(id);
        return s;
    }
}
