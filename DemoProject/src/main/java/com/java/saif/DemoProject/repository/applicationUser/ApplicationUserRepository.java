package com.java.saif.DemoProject.repository.applicationUser;

import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import com.java.saif.DemoProject.models.user.User;

import java.util.List;

public interface ApplicationUserRepository {
    ApplicationUser createApplicationUser(ApplicationUser applicationUser);

    void deleteApplicationUserById(Long applicationUserId);

    List<Application> listApplicationsForUser(String userEmail);
}
