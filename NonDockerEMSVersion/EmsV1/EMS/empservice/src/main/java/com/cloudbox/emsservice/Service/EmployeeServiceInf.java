package com.cloudbox.emsservice.Service;

import com.cloudbox.models_service.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInf {

    Employee save(Employee emp);

    Optional<Employee> findbyid(Integer Id);

    List<Employee> findAll();

    void delete(Integer id);

}
