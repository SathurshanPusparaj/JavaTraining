package com.cloudbox.emsui;

import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.ProjectTask;
import com.cloudbox.models_service.models.Projects;
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

import java.util.logging.Logger;

@Controller
public class ProjectUiController {

    @Autowired
    RestTemplate restTemplate;

    String status = null;

    @RequestMapping(value = "/projects",method = RequestMethod.GET)
    String getAllProjects(Model model){

        try {
            ResponseEntity<Projects[]> projectlist = restTemplate.exchange("http://localhost:8282/projects", HttpMethod.GET,new HttpEntity<Projects>(new HttpHeaders()),Projects[].class);

            model.addAttribute("project",new Projects());
            model.addAttribute("projects",projectlist.getBody());
        }catch (HttpStatusCodeException ex){
            model.addAttribute("error",ex.toString());
        }

        if(status!=null){
            model.addAttribute("status",status);
            status=null;
        }

        return "project_list";
    }
    @RequestMapping(value = "/projects",method = RequestMethod.POST)
    String saveProject(@ModelAttribute("project") Projects project){

        try{
            ResponseEntity<Projects> saveProject = restTemplate.postForEntity("http://localhost:8282/projects",project,Projects.class);
            status="active";
        }catch (HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(EmpUiController.class.getName());
            logger.warning(ex.toString());
            status="error";
        }
        return "redirect:/projects";
    }
    @RequestMapping(value = "/projects/{id}",method = RequestMethod.GET)
    String findByidProject(@PathVariable Integer id, Model model){

        try{
            ResponseEntity<Projects> project = restTemplate.exchange("http://localhost:8282/projects/"+id, HttpMethod.GET,new HttpEntity<Projects>(new HttpHeaders()),Projects.class);
            model.addAttribute("findproject",project.getBody());
        }catch (HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(EmpUiController.class.getName());
            logger.warning(ex.toString());
        }
        return "project_info";
    }
    @RequestMapping(value = "/projects/delete/{id}",method = RequestMethod.GET)
    String deleteproject(@PathVariable Integer id, Model model){

        try{
            restTemplate.delete("http://localhost:8282/projects/"+id);
            status = "del_active";
        }catch (HttpStatusCodeException ex){
            status ="del_error";
            Logger logger = Logger.getLogger(EmpUiController.class.getName());
            logger.warning(ex.toString());
        }
        return "redirect:/project_list";
    }
}
