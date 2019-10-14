package com.cloudbox.emsui;

import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.ProjectTask;
import com.cloudbox.models_service.models.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
public class EmpUiController {

    String status=null;

    @Autowired
    private RestTemplate restTemplate;


    HttpHeaders gethttpheaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        return  httpHeaders;
    }

    HttpEntity gethttpEntity(){
        return new HttpEntity<Employee>(gethttpheaders());
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    String getindexpage(){
        return "index";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    String gethomepage(Model model){
        model.addAttribute("username",AccessTokenConfigurer.getPrincipalName());
        model.addAttribute("privilage",AccessTokenConfigurer.getAuthorities());

        return "home";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    String getAllEmployee(Model model){

        ResponseEntity<Employee[]> emplist = restTemplate.exchange("http://localhost:8181/employees", HttpMethod.GET,gethttpEntity(),Employee[].class);

        model.addAttribute("employee",new Employee());
        model.addAttribute("employees",emplist.getBody());
        model.addAttribute("username",AccessTokenConfigurer.getPrincipalName());
        model.addAttribute("privilage",AccessTokenConfigurer.getAuthorities());
        model.addAttribute("error",null);

        if(status!=null){
            model.addAttribute("status",status);
            status=null;
        }
        return "employee_list";
    }
    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    String saveEmployee(@ModelAttribute("employee") Employee employee){

        HttpEntity<Employee> httpEntity = new HttpEntity<>(employee,gethttpheaders());

        try{
            ResponseEntity<Employee> saveemp = restTemplate.postForEntity("http://localhost:8181/employees",httpEntity,Employee.class);
            status="active";
        }catch (HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(EmpUiController.class.getName());
            logger.warning(ex.toString());
            status="error";
        }

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/delete/{id}",method = RequestMethod.GET)
    String deleteEmployee(@PathVariable Integer id){

        try{
            restTemplate.exchange("http://localhost:8181/employees/"+id,HttpMethod.DELETE,gethttpEntity(),Employee.class);
            status="del_active";
        }catch(HttpStatusCodeException ex){
            Logger logger = Logger.getLogger(EmpUiController.class.getName());
            logger.warning(ex.toString());
            status="del_error";
        }
        return "redirect:/employees";
    }
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.GET)
    String findByidEmployee(@PathVariable Integer id, Model model){

        ResponseEntity<Employee> employee = restTemplate.exchange("http://localhost:8181/employees/"+id, HttpMethod.GET,gethttpEntity(),Employee.class);

        ResponseEntity<Projects[]> projects = restTemplate.exchange("http://localhost:8181/employees/"+id+"/projects", HttpMethod.GET,new HttpEntity<Projects>(gethttpheaders()),Projects[].class);

        for (Projects p:projects.getBody()){
            System.out.println(p.toString());
        }


        model.addAttribute("employee",employee.getBody());
        model.addAttribute("projects",projects.getBody());
        model.addAttribute("username",AccessTokenConfigurer.getPrincipalName());
        model.addAttribute("privilage",AccessTokenConfigurer.getAuthorities());

        return "employee_info";
    }

}
