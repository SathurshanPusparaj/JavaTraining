package com.dox.springdatajpaexample.repository;

import com.dox.springdatajpaexample.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryImpl extends JpaRepository<Student,Integer> {
}
