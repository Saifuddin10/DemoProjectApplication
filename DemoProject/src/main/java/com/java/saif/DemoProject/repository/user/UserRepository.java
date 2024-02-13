package com.java.saif.DemoProject.repository.user;

import com.java.saif.DemoProject.models.user.User;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    User createUser(User user);

    User getUserById(long id);

    void deleteUserById(long userId);

    List<User> listUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob);

    User updateUser(User user);

    User getUserByFirstName(String name);
}
