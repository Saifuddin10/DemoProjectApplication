package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationUserDAO extends JpaRepository<ApplicationUser, Long> {
    List<Application> findAllApplicationByUserEmail(String userEmail);
}
