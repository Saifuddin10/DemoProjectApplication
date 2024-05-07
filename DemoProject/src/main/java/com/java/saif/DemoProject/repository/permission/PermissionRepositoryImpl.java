package com.java.saif.DemoProject.repository.permission;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.DAO.PermissionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository {
    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDAO.save(permission);
    }

    @Override
    public Permission getPermissionById(Long permissionId) {
        return permissionDAO.findById(permissionId).orElse(null);
    }

    @Override
    public void deletePermissionById(long permissionId) {
        permissionDAO.deleteById(permissionId);
    }

    @Override
    public List<Permission> listPermissions(Long id, String name, String description, String type) {
        List<Permission> permissions = new ArrayList<>();
        if (id != null) {
            permissions.add(permissionDAO.findById(id).get());
            return permissions;
        }
        if (name != null) {
            return permissionDAO.findAllByName(name);
        }
        if (description != null) {
            return permissionDAO.findAllByDescription(description);
        }
        if (type != null) {
            return permissionDAO.findAllByType(type);
        }
        return permissionDAO.findAll();
    }

    @Override
    public Permission updatePermissionRequest(Permission permission) {
        return permissionDAO.save(permission);
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        return permissionDAO.findByName(permissionName);
    }

}
