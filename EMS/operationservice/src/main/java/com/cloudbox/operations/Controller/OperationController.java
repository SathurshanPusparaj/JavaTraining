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

        Employee emp = new Employee();
        emp.setEmpid(1);

        Projects pro = new Projects();
        pro.setPid(1);

        Task task = new Task();
        task.setTid(1);
        operationService.save(new ProjectTask(emp,pro,task));
    }

    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    ProjectTask saveOperation(@RequestBody EmpProjectTask empProjectTask){

        System.out.println(empProjectTask.getEmpid());
        System.out.println(empProjectTask.getPid());
        System.out.println(empProjectTask.getTid());

        Employee emp = new Employee();
        emp.setEmpid(empProjectTask.getEmpid());

        Projects project = new Projects();
        project.setPid(empProjectTask.getPid());

        Task task = new Task();
        task.setTid(task.getTid());

         return operationService.save(new ProjectTask(emp,project,task));
    }
}
