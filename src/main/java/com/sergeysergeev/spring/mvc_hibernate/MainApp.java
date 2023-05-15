package com.sergeysergeev.spring.mvc_hibernate;

import com.sergeysergeev.spring.mvc_hibernate.config.AppConfig;
import com.sergeysergeev.spring.mvc_hibernate.model.User;
import com.sergeysergeev.spring.mvc_hibernate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("Jack", "London", "jacklondon@gmail.com"));
        userService.addUser(new User("Kurt", "Russel", "kurtrassel@gmail.com"));
        userService.addUser(new User("Megan", "Olivie", "meganolivie@gmail.com"));
        userService.addUser(new User("Mighty", "Mouse", "mightymouse@gmail.com"));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();
        }
        context.close();
    }
}
