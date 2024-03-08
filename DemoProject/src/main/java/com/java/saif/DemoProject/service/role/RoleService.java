package com.java.saif.DemoProject.service.role;

import com.java.saif.DemoProject.models.role.CreateRoleRequest;
import com.java.saif.DemoProject.models.role.Role;
import com.java.saif.DemoProject.models.role.UpdateRoleRequest;

import java.util.List;

public interface RoleService {
    Role createRole(CreateRoleRequest createRoleRequest);

    Role getRoleById(long roleId);

    void deleteRoleById(long roleId);

    Role updateRole(long roleId, UpdateRoleRequest updateRoleRequest);

    List<Role> listRoles(Long id, String name, String description, String type, String displayName, boolean internal);
}
