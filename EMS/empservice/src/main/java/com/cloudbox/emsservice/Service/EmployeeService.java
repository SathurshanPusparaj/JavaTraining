package com.cloudbox.emsservice.Service;

import com.cloudbox.emsservice.Repository.EmpRepository;
import com.cloudbox.models_service.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements  EmployeeServiceInf{

    @Autowired
    EmpRepository empRepository;

    @Override
    public Employee save(Employee emp) {
        return empRepository.save(emp);
    }

    @Override
    public Optional<Employee> findbyid(Integer Id) {
        return empRepository.findById(Id);
    }

    @Override
    public List<Employee> findAll() {
        return empRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
         empRepository.deleteById(id);
    }
}
