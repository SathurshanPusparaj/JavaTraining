package com.cloudbox.emsui;

import com.cloudbox.models_service.models.Employee;
import com.cloudbox.models_service.models.ProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
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

    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    String getAllEmployee(Model model){

        ResponseEntity<Employee[]> emplist = restTemplate.exchange("http://localhost:8181/employees", HttpMethod.GET,new HttpEntity<Employee>(new HttpHeaders()),Employee[].class);

        model.addAttribute("employee",new Employee());
        model.addAttribute("employees",emplist.getBody());
        model.addAttribute("error",null);

        if(status!=null){
            model.addAttribute("status",status);
            status=null;
        }
        return "employee_list";
    }
    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    String saveEmployee(@ModelAttribute("employee") Employee employee){

        try{
            ResponseEntity<Employee> saveemp = restTemplate.postForEntity("http://localhost:8181/employees",employee,Employee.class);
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
            restTemplate.delete("http://localhost:8181/employees/"+id);
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

        ResponseEntity<Employee> employee = restTemplate.exchange("http://localhost:8181/employees/"+id, HttpMethod.GET,new HttpEntity<Employee>(new HttpHeaders()),Employee.class);

       for(ProjectTask projectTask:employee.getBody().getProjectTasks()){
            System.out.println(projectTask.getEmpProjectTask().getPid());
        }

        model.addAttribute("employee",employee.getBody());
        return "employee_info";
    }
}
