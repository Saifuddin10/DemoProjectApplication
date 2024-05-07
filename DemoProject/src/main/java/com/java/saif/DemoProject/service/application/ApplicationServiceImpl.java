package com.java.saif.DemoProject.service.application;

import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.application.CreateApplicationRequest;
import com.java.saif.DemoProject.models.application.UpdateApplicationRequest;
import com.java.saif.DemoProject.repository.application.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application creteApplication(CreateApplicationRequest createApplicationRequest) {
        Application application = new Application();
        application.setName(createApplicationRequest.getName());
        application.setDisplayName(createApplicationRequest.getDisplayName());
        application.setLoginUrl(createApplicationRequest.getLoginUrl());
        application.setLogoutUrl(createApplicationRequest.getLogoutUrl());
        application.setVersion(createApplicationRequest.getVersion());
        application.setDescription(createApplicationRequest.getDescription());
        application.setActive(createApplicationRequest.isActive());
        return applicationRepository.createApplication(application);
    }

    @Override
    public Application getApplicationById(long applicationId) {
        return applicationRepository.getApplicationById(applicationId);
    }

    @Override
    public void deleteApplicationById(long applicationId) {
        applicationRepository.deleteApplicationById(applicationId);
    }

    @Override
    public List<Application> listApplications(Long id, String name, String displayName, String loginUrl,
                                              String logoutUrl, Long version, String description, boolean active) {
        return applicationRepository.listApplications(id, name, description, loginUrl, logoutUrl, version,
                description, active);
    }

    @Override
    public Application updateApplication(long applicationId, UpdateApplicationRequest updateApplicationRequest) {
        Application application = applicationRepository.getApplicationById(applicationId);
        boolean updatingActiveOnly = updateApplicationRequest.getDisplayName() == null &&
                updateApplicationRequest.getLoginUrl() == null &&
                updateApplicationRequest.getLogoutUrl() == null &&
                updateApplicationRequest.getVersion() == null &&
                updateApplicationRequest.getDescription() == null;
        if (updatingActiveOnly) {
            application.setActive(updateApplicationRequest.isActive());
        } else {
            if (updateApplicationRequest.isActive() != application.isActive()) {
                throw new IllegalArgumentException("Updating 'active' field must be done individually.");
            }
            application.setDisplayName(updateApplicationRequest.getDisplayName());
            application.setLoginUrl(updateApplicationRequest.getLoginUrl());
            application.setLogoutUrl(updateApplicationRequest.getLogoutUrl());
            application.setVersion(updateApplicationRequest.getVersion());
            application.setDescription(updateApplicationRequest.getDescription());
        }
        return applicationRepository.updateApplication(application);
    }
}