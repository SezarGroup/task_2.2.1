package com.sergeysergeev.spring.mvc_hibernate.service;

import com.sergeysergeev.spring.mvc_hibernate.dao.UserDAO;
import com.sergeysergeev.spring.mvc_hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserByCar(String model, int serial) {
        return userDao.getUserByCar(model, serial);
    }
}
