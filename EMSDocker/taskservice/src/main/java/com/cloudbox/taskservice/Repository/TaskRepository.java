package com.cloudbox.taskservice.Repository;

import com.cloudbox.models_service.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
