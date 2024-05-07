package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.rolePermission.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionDAO extends JpaRepository<RolePermission, Long> {

    List<Permission> findPermissionsByRoleName(String permissionName);
}
