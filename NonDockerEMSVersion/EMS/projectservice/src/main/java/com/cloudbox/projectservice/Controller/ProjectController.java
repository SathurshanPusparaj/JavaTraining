package com.cloudbox.projectservice.Controller;

import com.cloudbox.models_service.models.Projects;
import com.cloudbox.projectservice.Service.ProjectServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectServiceInf projectServiceInf;

    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    Projects saveProject(@RequestBody Projects projects){
        return projectServiceInf.save(projects);
    }


    @RequestMapping(value = "/projects/{id}",method = RequestMethod.GET)
    Optional<Projects> findProjectById(@PathVariable Integer id){
        return projectServiceInf.findbyid(id);
    }


    @RequestMapping(value = "/projects",method = RequestMethod.GET)
    List<Projects> findAllProject(){
        return projectServiceInf.findAll();
    }


    @RequestMapping(value = "/projects/{id}",method = RequestMethod.DELETE)
    void saveProject(@PathVariable Integer id){
        try{
            projectServiceInf.remove(id);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }

    @RequestMapping(value = "/pro",method = RequestMethod.GET)
    void txProject(){
       Projects projects = new Projects();
       projects.setProjectName("EMS");
       projects.setProjectDescription("Employee Management System");
       projects.setStatus("active");
       Date date = new Date(Calendar.getInstance().getTime().getTime());
       projects.setStartDate(date);
       projects.setEndDate(date);

       projectServiceInf.save(projects);
    }

}
