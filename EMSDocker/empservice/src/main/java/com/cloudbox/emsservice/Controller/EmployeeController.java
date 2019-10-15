package com.cloudbox.emsservice.Controller;

import com.cloudbox.emsservice.Service.EmployeeServiceInf;
import com.cloudbox.emsservice.config.AccessTokenConfigurer;
import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.Projects;
import com.cloudbox.models_service.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Bean
    RestTemplate getrestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EmployeeServiceInf employeeServiceInf;

    HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization",AccessTokenConfigurer.getAccessToken());
        return httpHeaders;
    }


    @PreAuthorize("hasRole('ROLE_MANAGER')")
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

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    void deleteEmployee(@PathVariable Integer id){
        try{
            employeeServiceInf.delete(id);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }

    @RequestMapping(value = "/employees/{id}/projects",method = RequestMethod.GET)
    List<Projects> getEmployeeProjects(@PathVariable Integer id){
        ResponseEntity<Projects[]> projectlist = restTemplate.exchange("http://dockeroperation:8484/operations/employees/"+id+"/projects", HttpMethod.GET,new HttpEntity<Projects>(getHttpHeaders()),Projects[].class);

        return Arrays.asList(projectlist.getBody());
    }

    @RequestMapping(value = "/employees/{eid}/projects/{pid}",method = RequestMethod.GET)
    List<Task> getTask(@PathVariable Integer eid,@PathVariable Integer pid){
        ResponseEntity<Task[]> tasklist = restTemplate.exchange("http://dockeroperation:8484/operations/employees/"+eid+"/projects/"+pid, HttpMethod.GET,new HttpEntity<Task>(getHttpHeaders()),Task[].class);

        return Arrays.asList(tasklist.getBody());
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
