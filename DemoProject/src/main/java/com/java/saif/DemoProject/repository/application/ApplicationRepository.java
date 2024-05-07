package com.java.saif.DemoProject.repository.application;

import com.java.saif.DemoProject.models.application.Application;

import java.util.List;

public interface ApplicationRepository {

    Application createApplication(Application application);

    Application getApplicationById(long applicationId);

    void deleteApplicationById(long applicationId);

    List<Application> listApplications(Long id, String name, String description, String loginUrl, String logoutUrl, Long version, String description1, boolean active);

    Application updateApplication(Application application);

    Application getApplicationByName(String applicationName);
}
