package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
}
