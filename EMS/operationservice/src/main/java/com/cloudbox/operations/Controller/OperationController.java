package com.cloudbox.operations.Controller;

import com.cloudbox.models_service.models.*;
import com.cloudbox.operations.Service.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OperationServiceImpl operationService;

    @RequestMapping(value = "/operate",method = RequestMethod.GET)
    void dummyOperation(){

        Employee emp = new Employee(1);
        Projects pro = new Projects(1);
        Task task = new Task(1);

        operationService.save(new ProjectTask(emp,pro,task));
    }

    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    ProjectTask saveOperation(@RequestBody EmpProjectTask empProjectTask){

        Employee emp = new Employee(empProjectTask.getEmpid());
        Projects project = new Projects(empProjectTask.getPid());
        Task task = new Task(empProjectTask.getTid());
         return operationService.save(new ProjectTask(emp,project,task));
    }
    @RequestMapping(value = "/operations/employees/{eid}/projects",method = RequestMethod.GET)
    List<Projects> findProjectsbypid(@PathVariable Integer eid){

        return operationService.findProjectsbyeid(eid);

    }
    @RequestMapping(value = "/operations/employees/{eid}/projects/{pid}",method = RequestMethod.GET)
    List<Task> findTaskbypid(@PathVariable Integer eid, @PathVariable Integer pid){

        return operationService.findTasksbyeid(eid,pid);

    }
}
