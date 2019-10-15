package com.cloudbox.projectservice.Service;

import com.cloudbox.models_service.models.Projects;
import com.cloudbox.projectservice.Repository.ProjectRespositoryInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectServiceInf {

    @Autowired
    ProjectRespositoryInf repositoryInf;

    @Override
    public Projects save(Projects projects) {
        return repositoryInf.save(projects);
    }

    @Override
    public Optional<Projects> findbyid(Integer Id) {
        return repositoryInf.findById(Id);
    }

    @Override
    public List<Projects> findAll() {
        return repositoryInf.findAll();
    }

    @Override
    public void remove(Integer id) {
        repositoryInf.deleteById(id);
    }
}
