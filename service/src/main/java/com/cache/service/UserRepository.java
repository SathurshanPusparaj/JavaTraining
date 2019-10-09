package com.cache.service;

import Model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    void save(User user);
    Map<String,User> findAll();
    User finById(String id);
    void update(User user);
    void delete(String id);
}
