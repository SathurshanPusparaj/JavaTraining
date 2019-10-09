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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class OperationUiController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    String mappingAll(Model model){

        ResponseEntity<Employee[]> emplist = restTemplate.exchange("http://localhost:8181/employees", HttpMethod.GET,new HttpEntity<Employee>(new HttpHeaders()),Employee[].class);
        model.addAttribute("employees",emplist.getBody());

        ResponseEntity<Projects[]> projectlist = restTemplate.exchange("http://localhost:8282/projects", HttpMethod.GET,new HttpEntity<Projects>(new HttpHeaders()),Projects[].class);
        model.addAttribute("projects",projectlist.getBody());

        ResponseEntity<Task[]> tasklist = restTemplate.exchange("http://localhost:8383/tasks", HttpMethod.GET,new HttpEntity<Task>(new HttpHeaders()),Task[].class);
        model.addAttribute("tasks",tasklist.getBody());

        model.addAttribute("employee",new Employee());
        model.addAttribute("project",new Projects());
        model.addAttribute("task",new Task());

        return "operations";
    }
    @RequestMapping(value = "/operations",method = RequestMethod.POST)
    String postAllmapping(@ModelAttribute("employee") Employee employee,@ModelAttribute("project") Projects projects,@ModelAttribute("task") Task task  ){

        return "redirect:/operations";
    }

}
