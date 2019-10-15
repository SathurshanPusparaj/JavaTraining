package com.cloudbox.taskservice.Service;

import com.cloudbox.models_service.models.Task;
import com.cloudbox.taskservice.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskServiceInf{

    @Autowired
    TaskRepository taskRepository;


    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findbyid(Integer Id) {
        return taskRepository.findById(Id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        taskRepository.deleteById(id);
    }
}
