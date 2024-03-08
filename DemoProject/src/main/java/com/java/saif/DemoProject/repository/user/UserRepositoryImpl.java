package com.java.saif.DemoProject.repository.user;

import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDAO userDAO;


    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = userDAO.findById(id);
        return user.orElse(null);
    }

    @Override
    public void deleteUserById(long userId) {
        userDAO.deleteById(userId);
    }

    @Override
    public List<User> listUsers(Long id, String firstName, String lastName,
                                String email, Integer age, Date dob) {
        List<User> users = new ArrayList<>();
        if (id != null) {
            users.add(userDAO.findById(id).get());
            return users;
        }
        if (firstName != null) {
            return userDAO.findAllByFirstName(firstName);
        }
        if (lastName != null) {
            return userDAO.findAllByLastName(lastName);
        }
        if (email != null) {
            return userDAO.findAllByEmail(email);
        }
        if (age != null) {
            return userDAO.findAllByAge(age);
        }
        if (dob != null) {
            users.add(userDAO.findByDob(dob));
            return users;
        }
        return userDAO.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User getUserByFirstName(String name) {
        return userDAO.findByFirstName(name);
    }
}
