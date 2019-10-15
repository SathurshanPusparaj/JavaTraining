package com.cloudbox.projectservice.Repository;

import com.cloudbox.models_service.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRespositoryInf extends JpaRepository<Projects,Integer> {
}
