package com.dox.springdatajpaexample;

import com.dox.springdatajpaexample.Service.ServiceInf;
import com.dox.springdatajpaexample.modal.Address;
import com.dox.springdatajpaexample.modal.Student;
import com.dox.springdatajpaexample.modal.Telephone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sms")
public class StudentController {

    @Autowired
    ServiceInf studentService;

    @RequestMapping(value = "/hello")
    public String greeting(){
        return "Hello springboot";
    }


    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Optional<Student> getStudentById(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/teststudent",method = RequestMethod.GET)
    public Student getStudent(){
        Student student = new Student();
        student.setName("Saman");
        Address address = new Address();
        address.setCity("Galle");
        student.setAddress(address);

        List<Telephone> telephones = new ArrayList<>();
        Telephone telephone = new Telephone();
        telephone.setNumber("02356523566");
        telephone.setStudent(student);
        telephones.add(telephone);

        student.setTelephones(telephones);

        return student;
    }
}
