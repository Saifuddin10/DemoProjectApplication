package com.java.saif.DemoProject.service.user;

import com.java.saif.DemoProject.models.user.CreateUserRequest;
import com.java.saif.DemoProject.models.user.UpdateUserRequest;
import com.java.saif.DemoProject.models.user.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User getUserById(long id);

    User createUser(CreateUserRequest createUserRequest);

    void deleteUserById(long userId);

    List<User> listUsers(Long id, String firstName, String lastName, String email, Integer age, Date dob);

    User updateUser(long userId, UpdateUserRequest updateUserRequest);

    User getUserByFirstName(String name);
}
