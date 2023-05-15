package com.sergeysergeev.spring.mvc_hibernate.service;

import com.sergeysergeev.spring.mvc_hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
}
