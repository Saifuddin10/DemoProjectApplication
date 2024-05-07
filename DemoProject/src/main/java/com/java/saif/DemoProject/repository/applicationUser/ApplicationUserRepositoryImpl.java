package com.java.saif.DemoProject.repository.applicationUser;

import com.java.saif.DemoProject.DAO.ApplicationUserDAO;
import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import com.java.saif.DemoProject.models.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationUserRepositoryImpl implements ApplicationUserRepository {

    @Autowired
    private ApplicationUserDAO applicationUserDAO;

    @Override
    public ApplicationUser createApplicationUser(ApplicationUser applicationUser) {
        return applicationUserDAO.save(applicationUser);
    }

    @Override
    public void deleteApplicationUserById(Long applicationUserId) {
        applicationUserDAO.deleteById(applicationUserId);
    }

    @Override
    public List<Application> listApplicationsForUser(String userEmail) {
        return applicationUserDAO.findAllApplicationByUserEmail(userEmail);
    }
}