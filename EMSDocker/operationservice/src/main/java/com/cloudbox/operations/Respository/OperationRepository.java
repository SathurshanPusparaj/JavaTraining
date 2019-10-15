package com.cloudbox.operations.Respository;

import com.cloudbox.models_service.models.EmpProjectTask;
import com.cloudbox.models_service.models.ProjectTask;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<ProjectTask,Integer> {

}
