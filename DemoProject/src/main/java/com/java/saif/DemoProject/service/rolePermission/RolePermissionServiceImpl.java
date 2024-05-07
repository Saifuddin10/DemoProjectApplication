package com.java.saif.DemoProject.service.rolePermission;

import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.role.Role;
import com.java.saif.DemoProject.models.rolePermission.CreateRolePermissionRequest;
import com.java.saif.DemoProject.models.rolePermission.RolePermission;
import com.java.saif.DemoProject.models.rolePermission.RolePermissionResponse;
import com.java.saif.DemoProject.repository.permission.PermissionRepository;
import com.java.saif.DemoProject.repository.role.RoleRepository;
import com.java.saif.DemoProject.repository.rolePermission.RolePermissionRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public RolePermissionResponse createRolePermission(CreateRolePermissionRequest createRolePermissionRequest) {
        Role role = roleRepository.getRoleByName(createRolePermissionRequest.getRoleName());
        if (role == null) {
            throw new IllegalArgumentException("This Role is not available");
        }
        Permission permission = permissionRepository.getPermissionByName(createRolePermissionRequest.getPermissionName());
        if (permission == null) {
            throw new IllegalArgumentException("This type of permission is not available");
        }
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        RolePermission createdRolePermission = rolePermissionRepository.createRolePermission(rolePermission);
        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RolePermissionResponse rolePermissionResponse = mapper.map(createdRolePermission, RolePermissionResponse.class);
        return rolePermissionResponse;
    }

    @Override
    public void deleteRolePermissionById(Long rolePermissionId) {
        rolePermissionRepository.deleteRolePermissionById(rolePermissionId);
    }

    @Override
    public List<Permission> listPermissionsForRole(String roleName) {
        List<Permission> permissions = new ArrayList<>();
        try {
            rolePermissionRepository.listPermissionsForRole(roleName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return permissions;
    }
}