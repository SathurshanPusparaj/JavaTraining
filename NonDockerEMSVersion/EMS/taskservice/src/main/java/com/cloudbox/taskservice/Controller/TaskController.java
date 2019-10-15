package com.cloudbox.taskservice.Controller;

import com.cloudbox.models_service.models.Task;
import com.cloudbox.taskservice.Service.TaskServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    TaskServiceInf taskServiceInf;

    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    Task saveTask(@RequestBody Task task){
        return taskServiceInf.save(task);
    }


    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.GET)
    Optional<Task> findTaskById(@PathVariable Integer id){
        return taskServiceInf.findbyid(id);
    }


    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    List<Task> findAllTask(){
        return taskServiceInf.findAll();
    }


    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.DELETE)
    void deleteTask(@PathVariable Integer id){
        try{
            taskServiceInf.remove(id);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    @RequestMapping(value = "/task",method = RequestMethod.GET)
    void Task(){
        Task task = new Task();
        task.setTaskName("Create Employee Service");
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        task.setCreated(date);
        task.setTaskCatogary("Generate");

        taskServiceInf.save(task);
    }
}
