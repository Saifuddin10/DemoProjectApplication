package com.java.saif.DemoProject.service.rolePermission;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.rolePermission.CreateRolePermissionRequest;
import com.java.saif.DemoProject.models.rolePermission.RolePermissionResponse;

import java.util.List;

public interface RolePermissionService {
    RolePermissionResponse createRolePermission(CreateRolePermissionRequest createRolePermissionRequest);

    void deleteRolePermissionById(Long rolePermissionId);

    List<Permission> listPermissionsForRole(String permissionName);
}
