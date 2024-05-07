package com.java.saif.DemoProject.repository.rolePermission;

import com.java.saif.DemoProject.DAO.RolePermissionDAO;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.rolePermission.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionRepositoryImpl implements RolePermissionRepository {

    @Autowired
    private RolePermissionDAO rolePermissionDAO;

    @Override
    public RolePermission createRolePermission(RolePermission rolePermission) {
        return rolePermissionDAO.save(rolePermission);
    }

    @Override
    public void deleteRolePermissionById(Long rolePermissionId) {
        rolePermissionDAO.deleteById(rolePermissionId);
    }

    @Override
    public List<Permission> listPermissionsForRole(String roleName) {
        return rolePermissionDAO.findPermissionsByRoleName(roleName);
    }
}