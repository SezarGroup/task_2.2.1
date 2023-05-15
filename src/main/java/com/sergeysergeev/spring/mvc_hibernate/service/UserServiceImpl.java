package com.sergeysergeev.spring.mvc_hibernate.service;

import com.sergeysergeev.spring.mvc_hibernate.dao.UserDAO;
import com.sergeysergeev.spring.mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }
}
