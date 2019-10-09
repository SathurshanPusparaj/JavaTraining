package com.cloudbox.operations.Controller;

import com.cloudbox.models_service.models.Employee;
import com.cloudbox.operations.Service.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    @Autowired
    OperationServiceImpl operationService;

    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    void saveOperation(){
        operationService.getAll();
    }
}
