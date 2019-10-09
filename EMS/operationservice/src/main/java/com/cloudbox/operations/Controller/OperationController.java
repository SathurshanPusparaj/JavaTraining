package com.cloudbox.operations.Controller;

import com.cloudbox.models_service.models.*;
import com.cloudbox.operations.Service.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationController {

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
}
