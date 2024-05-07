package com.java.saif.DemoProject.service.application;

import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.application.CreateApplicationRequest;
import com.java.saif.DemoProject.models.application.UpdateApplicationRequest;

import java.util.List;

public interface ApplicationService {
    Application creteApplication(CreateApplicationRequest createApplicationRequest);

    Application getApplicationById(long applicationId);

    void deleteApplicationById(long applicationId);

    List<Application> listApplications(Long id, String name, String displayName, String loginUrl, String logoutUrl, Long version, String description, boolean active);

    Application updateApplication(long applicationId, UpdateApplicationRequest updateApplicationRequest);
}
