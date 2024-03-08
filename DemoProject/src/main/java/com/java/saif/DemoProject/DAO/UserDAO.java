package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    User getUserById(long id);

    User findByFirstName(String name);

    List<User> findAllByFirstName(String name);

    List<User> findAllByLastName(String lastName);

    List<User> findAllByEmail(String email);

    List<User> findAllByAge(Integer age);

    User findByDob(Date dob);
}
