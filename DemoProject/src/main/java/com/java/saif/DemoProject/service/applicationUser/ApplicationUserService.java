package com.java.saif.DemoProject.service.applicationUser;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUserResponse;
import com.java.saif.DemoProject.models.applicationUser.CreateApplicationUserRequest;

import java.util.List;

public interface ApplicationUserService {
    ApplicationUserResponse createApplicationUser(CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException;

    void deleteApplicationUserById(Long applicationUserId);

    List<Application> listApplicationsForUser(String userEmail);
}
