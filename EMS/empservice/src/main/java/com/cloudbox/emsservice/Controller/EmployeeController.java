package com.cloudbox.emsservice.Controller;

import com.cloudbox.emsservice.Service.EmployeeServiceInf;
import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.ProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceInf employeeServiceInf;

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    Employee saveEmployee(@RequestBody Employee employee){
        return employeeServiceInf.save(employee);
    }


    @RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
    Optional<Employee> findEmployeeById(@PathVariable Integer id){
        return employeeServiceInf.findbyid(id);
    }


    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    List<Employee> findAllEmployee(){
        return employeeServiceInf.findAll();
    }


    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    void deleteEmployee(@PathVariable Integer id){
        try{
            employeeServiceInf.delete(id);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
    @RequestMapping(value = "/employ",method = RequestMethod.GET)
    void createEmployee(){
        Employee emp = new Employee();
        emp.setFirstName("Rahul");
        emp.setLastName("Raja");
        emp.setDesignation("associate");
        emp.setEmail("raja@gmail.com");
        emp.setPhoneNumber((long)0334343434);
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        emp.setDob(date);
        employeeServiceInf.save(emp);
    }
}
