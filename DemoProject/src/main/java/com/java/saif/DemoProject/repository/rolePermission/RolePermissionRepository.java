package com.java.saif.DemoProject.repository.rolePermission;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.rolePermission.RolePermission;

import java.util.List;

public interface RolePermissionRepository {
    RolePermission createRolePermission(RolePermission rolePermission);

    void deleteRolePermissionById(Long rolePermissionId);

    List<Permission> listPermissionsForRole(String permissionName);
}
