package com.java.saif.DemoProject.repository.role;

import com.java.saif.DemoProject.DAO.RoleDAO;
import com.java.saif.DemoProject.models.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepositoryImpl implements  RoleRepository{

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public Role createRole(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public Role getRoleById(long roleId) {
        Optional<Role>role = roleDAO.findById(roleId);
        return role.orElse(null);
    }

    @Override
    public void deleteRoleById(long roleId) {
        roleDAO.deleteById(roleId);
    }

    @Override
    public List<Role> listRoles(Long id, String name, String description, String type, String displayName, boolean internal) {
        return roleDAO.findAll();
    }

    @Override
    public Role updateRole(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDAO.findByName(roleName);
    }
}
