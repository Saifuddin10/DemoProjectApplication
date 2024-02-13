package com.java.saif.DemoProject.service.user;

import com.java.saif.DemoProject.models.user.CreateUserRequest;
import com.java.saif.DemoProject.models.user.UpdateUserRequest;
import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.repository.user.UserRepository;
import com.java.saif.DemoProject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setAge(createUserRequest.getAge());
        user.setDob(createUserRequest.getDob());
        return userRepository.createUser(user);
    }

    @Override
    public void deleteUserById(long userId) {
        userRepository.deleteUserById(userId);
    }

    @Override
    public List<User> listUsers(Long id, String firstName, String lastName,
                                String email, Integer age, Date dob) {
        return userRepository.listUsers(id, firstName, lastName, email, age, dob);
    }

    @Override
    public User updateUser(long userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.getUserById(userId);
        if (user == null){
            throw new RuntimeException("User not found" + userId);
        }
        if (updateUserRequest.getFirstName() != null) {
            user.setFirstName(updateUserRequest.getFirstName());
        }
        if (updateUserRequest.getLastName() != null) {
            user.setLastName(updateUserRequest.getLastName());
        }
        return userRepository.updateUser(user);
    }

    @Override
    public User getUserByFirstName(String name) {
        return userRepository.getUserByFirstName(name);
    }


}
