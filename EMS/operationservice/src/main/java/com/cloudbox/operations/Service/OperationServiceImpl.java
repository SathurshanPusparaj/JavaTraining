package com.cloudbox.operations.Service;

import com.cloudbox.models_service.models.ProjectTask;
import com.cloudbox.operations.Respository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl {

    @Autowired
    OperationRepository operationRepository;

    public ProjectTask save(ProjectTask projectTask){
        return operationRepository.save(projectTask);
    }
}
