package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDAO extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
