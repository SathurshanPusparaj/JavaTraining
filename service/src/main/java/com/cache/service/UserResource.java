package com.cache.service;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/add/{id}/{name}",method = RequestMethod.GET)
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){

        userRepository.save(new User(id,name,"200000LKR"));

        return userRepository.finById(id);
    }

    @RequestMapping(value = "/update/{id}/{name}",method = RequestMethod.GET)
    public User update(@PathVariable("id") final String id,
                    @PathVariable("name") final String name){

        userRepository.save(new User(id,name,"250000LKR"));

        return userRepository.finById(id);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findbyid(@PathVariable("id") final String id){

        return userRepository.finById(id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Map<String, User> getallusers(){
        return userRepository.findAll();
    }
}
