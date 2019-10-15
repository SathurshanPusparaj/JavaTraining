package com.cloudbox.taskservice.Service;

import com.cloudbox.models_service.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInf {

    Task save(Task task);

    Optional<Task> findbyid(Integer Id);

    List<Task> findAll();

    void remove(Integer id);
}
