package com.java.saif.DemoProject.repository;

import com.java.saif.DemoProject.models.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDAO extends JpaRepository<Permission, Long> {

    List<Permission> findAllByName(String name);

    List<Permission> findAllByDescription(String description);

    List<Permission> findAllByType(String type);
}
