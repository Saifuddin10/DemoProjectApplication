package com.java.saif.DemoProject.service.role;

import com.java.saif.DemoProject.models.role.CreateRoleRequest;
import com.java.saif.DemoProject.models.role.Role;
import com.java.saif.DemoProject.models.role.UpdateRoleRequest;
import com.java.saif.DemoProject.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(CreateRoleRequest createRoleRequest) {
        Role role = new Role();
        role.setName(createRoleRequest.getName());
        role.setDescription(createRoleRequest.getDescription());
        role.setType(createRoleRequest.getType());
        role.setDisplayName(createRoleRequest.getDisplayName());
        role.setInternal(createRoleRequest.isInternal());
        return roleRepository.createRole(role);
    }

    @Override
    public Role getRoleById(long roleId) {
        return roleRepository.getRoleById(roleId);
    }

    @Override
    public void deleteRoleById(long roleId) {
        roleRepository.deleteRoleById(roleId);
    }

    @Override
    public Role updateRole(long roleId, UpdateRoleRequest updateRoleRequest) {
        Role role = roleRepository.getRoleById(roleId);
        role.setDescription(updateRoleRequest.getDescription());
        role.setDisplayName(updateRoleRequest.getDisplayName());
        return roleRepository.updateRole(role);
    }

    @Override
    public List<Role> listRoles(Long id, String name, String description, String type, String displayName, boolean internal) {
        return roleRepository.listRoles(id, name, description, type, displayName, internal);
    }
}
