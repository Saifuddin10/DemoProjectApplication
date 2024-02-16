package com.java.saif.DemoProject.controller.user;

import com.java.saif.DemoProject.models.user.CreateUserRequest;
import com.java.saif.DemoProject.models.user.UpdateUserRequest;
import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User controller", description = "Manages users in this Demo API")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(value = "*")
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create User", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateUserRequest.class))
            )
    })
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        User user = userService.createUser(createUserRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @CrossOrigin(value = "*")
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get User By Id", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))
            )
    })
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") long userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete User By Id", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public ResponseEntity<String> deleteUserById(@PathVariable long userId) {
        userService.deleteUserById(userId);
        String str = "User Deleted Successfully";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List Users", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))
            )
    })
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

    @PutMapping(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update User", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateUserRequest.class))
            )
    })
    public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userService.updateUser(userId, updateUserRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/users/get/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get User By Firstname", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))
            )
    })
    public ResponseEntity<User> getUserByFirstName(@PathVariable String name) {
        User user = userService.getUserByFirstName(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
