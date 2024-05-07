package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationDAO extends JpaRepository<Application, Long> {

    List<Application> findAllByName(String name);

    List<Application> findAllByDisplayName(String DisplayName);

    List<Application> findAllByLoginUrl(String LoginUrl);

    List<Application> findAllByLogoutUrl(String LogoutUrl);

    List<Application> findAllByVersion(Long Version);

    List<Application> findAllByDescription(String description);

    Application findAByName(String name);
}
