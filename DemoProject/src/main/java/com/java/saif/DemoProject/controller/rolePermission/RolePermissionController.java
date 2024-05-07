package com.java.saif.DemoProject.controller.rolePermission;

import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.rolePermission.CreateRolePermissionRequest;
import com.java.saif.DemoProject.models.rolePermission.RolePermission;
import com.java.saif.DemoProject.models.rolePermission.RolePermissionResponse;
import com.java.saif.DemoProject.service.rolePermission.RolePermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Permissions;
import java.util.List;

@RestController
@RequestMapping
@Tag(name = "Role Permission Controller", description = "Manage Role Permissions in Demo API")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @CrossOrigin(value = "*")
    @PostMapping("/rolePermissions")
    @Operation(summary = "Create Role Permissions", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateRolePermissionRequest.class))
            )
    })
    public RolePermissionResponse createRolePermission(@RequestBody CreateRolePermissionRequest createRolePermissionRequest) {
        return rolePermissionService.createRolePermission(createRolePermissionRequest);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/roles/{name}/permissions")
    @Operation(summary = "List Permissions for Role", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = Permission.class))
            )
    })
    public ResponseEntity<List<Permission>> listPermissionsForRole(
            @RequestParam(required = false) String roleName
    ) {
        List<Permission> permissions = rolePermissionService.listPermissionsForRole(roleName);
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping(value = "/rolePermissions/{rolePermissionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete Application Users", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public ResponseEntity<String> deleteRolePermissionById(@PathVariable Long rolePermissionId) {
        rolePermissionService.deleteRolePermissionById(rolePermissionId);
        String str = "Role Permission deleted successfully";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}