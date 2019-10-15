package com.cloudbox.emsui;

import com.cloudbox.models_service.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Controller
public class OperationUiController {

    String status = null;

    HttpHeaders gethttpheaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        return  httpHeaders;
    }

    HttpEntity gethttpEntity(){
        return new HttpEntity<Employee>(gethttpheaders());
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    String mappingAll(Model model){

        ResponseEntity<Employee[]> emplist = restTemplate.exchange("http://dockeremployee:8181/employees", HttpMethod.GET,gethttpEntity(),Employee[].class);
        model.addAttribute("employees",emplist.getBody());

        ResponseEntity<Projects[]> projectlist = restTemplate.exchange("http://dockerproject:8282/projects", HttpMethod.GET,new HttpEntity<Projects>(gethttpheaders()),Projects[].class);
        model.addAttribute("projects",projectlist.getBody());

        ResponseEntity<Task[]> tasklist = restTemplate.exchange("http://dockertask:8383/tasks", HttpMethod.GET,new HttpEntity<Task>(gethttpheaders()),Task[].class);
        model.addAttribute("tasks",tasklist.getBody());

        model.addAttribute("employee",new Employee());
        model.addAttribute("project",new Projects());
        model.addAttribute("task",new Task());
        model.addAttribute("empProjectTask",new EmpProjectTask());
        model.addAttribute("username",AccessTokenConfigurer.getPrincipalName());
        model.addAttribute("privilage",AccessTokenConfigurer.getAuthorities());

        if(status!=null){
            model.addAttribute("status",status);
            status=null;
        }

        return "operations";
    }

    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    String postAllmapping(@ModelAttribute("projectTask") EmpProjectTask empProjectTask){

        HttpEntity<EmpProjectTask> httpEntity = new HttpEntity<>(empProjectTask,gethttpheaders());

        try{
            ResponseEntity<EmpProjectTask> saveProject = restTemplate.postForEntity("http://dockeroperation:8484/operations",httpEntity,EmpProjectTask.class);
            status="active";
        }catch (HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(OperationUiController.class.getName());
            logger.warning(ex.toString());
            status="error";
        }

        return "redirect:/operations";
    }

}
