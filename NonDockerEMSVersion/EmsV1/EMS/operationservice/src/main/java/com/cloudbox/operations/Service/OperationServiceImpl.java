package com.cloudbox.operations.Service;

import com.cloudbox.models_service.models.*;
import com.cloudbox.operations.Respository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OperationServiceImpl {

    @Autowired
    OperationRepository operationRepository;

    public ProjectTask save(ProjectTask projectTask){
        return operationRepository.save(projectTask);
    }

    public Set<Projects> findProjectsbyeid(Integer eid){

        ProjectTask pt = new ProjectTask();
        pt.setEmployee(new Employee(eid));
        Example<ProjectTask> examplept = Example.of(pt);

        //Iterable<ProjectTask> projectTasksingle = operationRepository.findAll(examplept);
        Set<Projects> projects = new HashSet<>();
        for (ProjectTask p : operationRepository.findAll(examplept)) {
                projects.add(p.getProjects());
        }

        return projects;
    }

    public List<Task> findTasksbyeid(Integer eid, Integer pid){

        ProjectTask pt = new ProjectTask();
        pt.setEmployee(new Employee(eid));
        pt.setProjects(new Projects(pid));

        Example<ProjectTask> employeeproject = Example.of(pt);

        List<Task> tasks = new ArrayList<>();
        for (ProjectTask p : operationRepository.findAll(employeeproject)) {
            tasks.add(p.getTask());
        }

        return tasks;
    }
}
