package com.java.saif.DemoProject.models.user;


import jakarta.validation.constraints.*;

import java.util.Date;

public class CreateUserRequest {
    @NotNull(message = "Username should not be null")
    private String firstName;
    @NotNull(message = "Username should not be null")
    private String lastName;
    @Email(message = "Invalid email address")
    private String email;
    @Min(18)
    @Max(60)
    private int age;
    private Date dob;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
