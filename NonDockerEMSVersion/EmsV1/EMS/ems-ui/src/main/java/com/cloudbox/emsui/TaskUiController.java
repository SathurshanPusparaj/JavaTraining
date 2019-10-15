package com.cloudbox.emsui;

import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.Projects;
import com.cloudbox.models_service.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class TaskUiController {

    @Autowired
    RestTemplate restTemplate;

    String status = null;

    HttpHeaders gethttpheaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        return  httpHeaders;
    }

    HttpEntity gethttpEntity(){
        return new HttpEntity<Task>(gethttpheaders());
    }

    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    String getAllTasks(Model model){

        try {
            ResponseEntity<Task[]> tasklist = restTemplate.exchange("http://localhost:8383/tasks", HttpMethod.GET,gethttpEntity(),Task[].class);

            model.addAttribute("task",new Task());
            model.addAttribute("tasks",tasklist.getBody());
            model.addAttribute("username",AccessTokenConfigurer.getPrincipalName());
            model.addAttribute("privilage",AccessTokenConfigurer.getAuthorities());
        }catch (HttpStatusCodeException ex){
            model.addAttribute("error",ex.toString());
        }

        if(status!=null){
            model.addAttribute("status",status);
            status=null;
        }

        return "task_list";
    }
    @RequestMapping(value = "/tasks/delete/{id}",method = RequestMethod.GET)
    String deletetask(@PathVariable Integer id, Model model){

        try{
            restTemplate.exchange("http://localhost:8383/tasks/"+id,HttpMethod.DELETE,gethttpEntity(),Task.class);
            status = "del_active";
        }catch (HttpStatusCodeException ex){
            status ="del_error";
            Logger logger = Logger.getLogger(TaskUiController.class.getName());
            logger.warning(ex.toString());
        }
        return "redirect:/tasks";
    }
    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
    String saveTask(@ModelAttribute("task") Task task){

        HttpEntity<Task> httpEntity = new HttpEntity<>(task,gethttpheaders());

        try{
            ResponseEntity<Task> savetask = restTemplate.postForEntity("http://localhost:8383/tasks",httpEntity,Task.class);
            status="active";
        }catch (HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(TaskUiController.class.getName());
            logger.warning(ex.toString());
            status="error";
        }
        return "redirect:/tasks";
    }
}
