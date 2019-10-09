package com.cloudbox.operations.Service;

import com.cloudbox.models_service.models.ProjectTask;
import com.cloudbox.operations.Respository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl {

    @Autowired
    OperationRepository operationRepository;

    public void getAll(){
        List<ProjectTask> ptsk = operationRepository.findAll();

        for(ProjectTask pt:ptsk){
            System.out.println(pt.getEmployee().getFirstName());
            System.out.println(pt.getProjects().getProjectName());
            System.out.println(pt.getTask().getTaskName());
        }
    }
}
