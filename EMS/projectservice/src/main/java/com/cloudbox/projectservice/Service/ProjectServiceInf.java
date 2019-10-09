package com.cloudbox.projectservice.Service;

import com.cloudbox.models_service.models.Projects;

import java.util.List;
import java.util.Optional;

public interface ProjectServiceInf {
    Projects save(Projects projects);

    Optional<Projects> findbyid(Integer Id);

    List<Projects> findAll();

    void remove(Integer id);
}
