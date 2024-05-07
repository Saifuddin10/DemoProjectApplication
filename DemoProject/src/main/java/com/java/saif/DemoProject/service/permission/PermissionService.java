package com.java.saif.DemoProject.service.permission;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.permission.CreatePermissionRequest;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.permission.UpdatePermissionRequest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface PermissionService {
    Permission createPermission(CreatePermissionRequest createPermissionRequest);

    Permission getPermissionById(Long permissionId) throws UserNotFoundException;

    void deletePermissionById(long permissionId) throws UserNotFoundException;

    List<Permission> listPermissions(Long id, String name, String description, String type);

    Permission updatePermissionRequest(long permissionId, UpdatePermissionRequest updatePermissionRequest);

}
