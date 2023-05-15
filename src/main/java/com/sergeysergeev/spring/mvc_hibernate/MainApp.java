package com.sergeysergeev.spring.mvc_hibernate;

import com.sergeysergeev.spring.mvc_hibernate.config.AppConfig;
import com.sergeysergeev.spring.mvc_hibernate.model.Car;
import com.sergeysergeev.spring.mvc_hibernate.model.User;
import com.sergeysergeev.spring.mvc_hibernate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.addUser(new User("Jack", "London", "jacklondon@gmail.com", new Car("toyota", 130)));
        userService.addUser(new User("Kurt", "Russel", "kurtrassel@gmail.com", new Car("subaru", 80)));
        userService.addUser(new User("Megan", "Olivie", "meganolivie@gmail.com", new Car("lexus", 570)));
        userService.addUser(new User("Mighty", "Mouse", "mightymouse@gmail.com", new Car("mercedes", 600)));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("User car = " + user.getCar());
            System.out.println();
        }

        System.out.println("get user = " + userService.getUserByCar("lexus", 570));
        context.close();
    }
}
