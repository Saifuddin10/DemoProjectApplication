package com.java.saif.DemoProject.repository.role;

import com.java.saif.DemoProject.models.role.Role;

import java.util.List;

public interface RoleRepository {
    void deleteRoleById(long roleId);

    Role createRole(Role role);

    Role getRoleById(long roleId);

    List<Role> listRoles(Long id, String name, String description, String type, String displayName, boolean internal);

    Role updateRole(Role role);

    Role getRoleByName(String roleName);
}
