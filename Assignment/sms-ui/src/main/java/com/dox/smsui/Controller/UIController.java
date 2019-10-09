package com.dox.smsui.Controller;

import com.dox.smsui.AccessTokenConfigurer;
import com.dox.springdatajpaexample.modal.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableOAuth2Sso
public class UIController  extends WebSecurityConfigurerAdapter {

    private String name="";

    @Bean
   RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    public RestTemplate restTemplate;

    public String beforeAdvice(){
           Authentication principal = SecurityContextHolder.getContext().getAuthentication();
           return principal.getName();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest().authenticated();

    }

    public HttpEntity getHttpEntity(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Student> httpEntity = new HttpEntity<Student>(httpHeaders);
        return  httpEntity;
    }

    @RequestMapping(value = "/")
    public String loadindex(){
        return "index";
    }

    @RequestMapping(value = "/showformadd")
    public String showFormAdd(Model model){
        model.addAttribute("username",beforeAdvice());
        return "create";
    }

    @RequestMapping(value = "/showformid",method = RequestMethod.GET)
    public String showStudentid(Model model){
        beforeAdvice();
        model.addAttribute("username",beforeAdvice());

        Student student = new Student();
        model.addAttribute("student",student);

        if(!name.isEmpty()){
            model.addAttribute("findname",name);
            name="";
        }



        return "student";
    }


    @RequestMapping(value = "/findbyid",method = RequestMethod.POST)
    public String findStudentById(@ModelAttribute("student") Student student){
        try{
            ResponseEntity<Student> responseEntity = restTemplate.exchange("http://localhost:8081/sms/students/"+student.getSid().toString(),HttpMethod.GET,getHttpEntity(),Student.class);
            name = responseEntity.getBody().getName();
        }catch(HttpStatusCodeException ex){
            ResponseEntity responseEntity = ResponseEntity.status(ex.getStatusCode()).body(ex.getResponseBodyAsString());
           // model.addAttribute("error",responseEntity);
        }
        return "redirect:/showformid";
    }

    @RequestMapping(value = "/showformall",method = RequestMethod.GET)
    public String showAllCustomer(Model model){
        beforeAdvice();
        model.addAttribute("username",beforeAdvice());

        try{
            ResponseEntity<Student[]> responseEntity = restTemplate.exchange("http://localhost:8081/sms/students", HttpMethod.GET,getHttpEntity(),Student[].class);
            model.addAttribute("Allusers",responseEntity.getBody());
        }catch (HttpStatusCodeException ex){
            ResponseEntity responseEntity = ResponseEntity.status(ex.getStatusCode()).body(ex.getResponseBodyAsString());
            model.addAttribute("error",responseEntity);
        }


        return "allstudent";
    }


}
