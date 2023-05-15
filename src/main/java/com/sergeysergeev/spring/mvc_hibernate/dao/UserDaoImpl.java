package com.sergeysergeev.spring.mvc_hibernate.dao;

import com.sergeysergeev.spring.mvc_hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    @Override
    public User getUserByCar(String model, int serial) {
        int id = (Integer) sessionFactory.getCurrentSession().createQuery(("select id from Car where " +
                "model = '" + model + "'and series = '" + serial + "'")).getSingleResult();
        return sessionFactory.getCurrentSession().createQuery("from User where id = '" + id + "'", User.class).getSingleResult();
    }
}
