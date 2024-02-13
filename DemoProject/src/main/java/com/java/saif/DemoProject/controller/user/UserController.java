package com.java.saif.DemoProject.controller.user;

import com.java.saif.DemoProject.models.user.CreateUserRequest;
import com.java.saif.DemoProject.models.user.UpdateUserRequest;
import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable long userId) {
        userService.deleteUserById(userId);
        String str = "User Deleted Successfully";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Date dob
    ) {
        List<User> user = userService.listUsers(id, firstName, lastName, email, age, dob);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userService.updateUser(userId, updateUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/get/{name}")
    public ResponseEntity<User> getUserByFirstName(@PathVariable String name) {
        User user = userService.getUserByFirstName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
