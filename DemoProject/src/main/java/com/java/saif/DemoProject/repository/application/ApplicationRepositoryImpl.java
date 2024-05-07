package com.java.saif.DemoProject.repository.application;

import com.java.saif.DemoProject.DAO.ApplicationDAO;
import com.java.saif.DemoProject.models.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository {

    @Autowired
    private ApplicationDAO applicationDAO;

    @Override
    public Application createApplication(Application application) {
        return applicationDAO.save(application);
    }

    @Override
    public Application getApplicationById(long applicationId) {
        Optional<Application> application = applicationDAO.findById(applicationId);
        return application.orElse(null);
    }

    @Override
    public void deleteApplicationById(long applicationId) {
        applicationDAO.deleteById(applicationId);
    }

    @Override
    public List<Application> listApplications(Long id, String name, String displayName, String loginUrl,
                                              String logoutUrl, Long version, String description, boolean active) {
        List<Application> applications = new ArrayList<>();
        if (id != null){
            applications.add(applicationDAO.findById(id).get());
            return applications;
        }
        if (name != null){
            return applicationDAO.findAllByName(name);
        }
        if (displayName != null){
            return applicationDAO.findAllByDisplayName(displayName);
        }
        if (loginUrl != null){
            return applicationDAO.findAllByLoginUrl(loginUrl);
        }
        if (logoutUrl != null){
            return applicationDAO.findAllByLogoutUrl(logoutUrl);
        }
        if (version != null){
            return applicationDAO.findAllByVersion(version);
        }
        if (description != null){
            return applicationDAO.findAllByDescription(description);
        }
        return applicationDAO.findAll();
    }

    @Override
    public Application updateApplication(Application application) {
        return applicationDAO.save(application);
    }

    @Override
    public Application getApplicationByName(String applicationName) {
        return applicationDAO.findAByName(applicationName);
    }
}
