package com.java.saif.DemoProject.controller.permission;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.permission.CreatePermissionRequest;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.permission.UpdatePermissionRequest;
import com.java.saif.DemoProject.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/permissions")
    public Permission createPermission(@RequestBody CreatePermissionRequest createPermissionRequest){
        return permissionService.createPermission(createPermissionRequest);
    }

   @GetMapping("/permissions/{id}")
   public Permission getPermissionById(@PathVariable(name = "id") Long permissionId) throws UserNotFoundException {
        return permissionService.getPermissionById(permissionId);
   }

    @DeleteMapping("/permissions/{permissionId}")
    public String deletePermissionById(@PathVariable long permissionId) {
        permissionService.deletePermissionById(permissionId);
        return "Permission Deleted Successfully";
    }

    @GetMapping("/permissions")
    public List<Permission> listPermissions(
            @RequestParam (required = false) Long id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String description,
            @RequestParam (required = false) String type
    ) {
        List<Permission> permissions = permissionService.listPermissions(id, name, description, type);
        return permissions;
    }

    @PutMapping("/permissions/{permissionId}")
    public Permission updatePermission(@PathVariable long permissionId, @RequestBody UpdatePermissionRequest updatePermissionRequest){
        return permissionService.updatePermissionRequest(permissionId, updatePermissionRequest);
    }
}