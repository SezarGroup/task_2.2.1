package com.sergeysergeev.spring.mvc_hibernate.dao;

import com.sergeysergeev.spring.mvc_hibernate.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void addUser(User user);

    User getUserByCar(String model, int serial);
}
