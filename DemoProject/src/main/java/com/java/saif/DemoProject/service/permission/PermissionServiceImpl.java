package com.java.saif.DemoProject.service.permission;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.permission.CreatePermissionRequest;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.permission.UpdatePermissionRequest;
import com.java.saif.DemoProject.repository.permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission createPermission(CreatePermissionRequest createPermissionRequest) {
        Permission permission = new Permission();
        permission.setName(createPermissionRequest.getName());
        permission.setDescription(createPermissionRequest.getDescription());
        permission.setType(createPermissionRequest.getType());
        return permissionRepository.createPermission(permission);
    }

    @Override
    public Permission getPermissionById(Long permissionId) {
        Permission permission = permissionRepository.getPermissionById(permissionId);
        if (permission == null){
            throw new UserNotFoundException("ID NOT FOUND : " + permissionId);
        }
        return permission;
    }

    @Override
    public void deletePermissionById(long permissionId) {
        Permission permission = permissionRepository.getPermissionById(permissionId);
        if (permission == null){
            throw new UserNotFoundException("ID NOT FOUND : " + permissionId);
        }
        permissionRepository.deletePermissionById(permissionId);
    }



    @Override
    public List<Permission> listPermissions(Long id, String name, String description, String type) {
        return permissionRepository.listPermissions(id, name, description, type);
    }


    @Override
    public Permission updatePermissionRequest(long permissionId, UpdatePermissionRequest updatePermissionRequest) {
        Permission permission = permissionRepository.getPermissionById(permissionId);
        if (permission == null) {
            throw new RuntimeException("Permission not found" + permissionId);
        }
        if (updatePermissionRequest.getDescription() != null) {
            permission.setDescription(updatePermissionRequest.getDescription());
        }
        if (updatePermissionRequest.getType() != null) {
            permission.setType(updatePermissionRequest.getType());
        }
        return permissionRepository.updatePermissionRequest(permission);
    }
}