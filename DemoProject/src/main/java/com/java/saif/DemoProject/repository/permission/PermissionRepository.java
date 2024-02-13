package com.java.saif.DemoProject.repository.permission;

import com.java.saif.DemoProject.models.permission.Permission;

import java.util.List;

public interface PermissionRepository {
    Permission createPermission(Permission permission);

    Permission getPermissionById(Long permissionId);

    void deletePermissionById(long permissionId);

    List<Permission> listPermissions(Long id, String name, String description, String type);

    Permission updatePermissionRequest(Permission permission);
}
