package com.java.saif.DemoProject.controller.permission;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.permission.CreatePermissionRequest;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.models.permission.UpdatePermissionRequest;
import com.java.saif.DemoProject.service.permission.PermissionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Permission Controller", description = "Manage Permissions in this Demo API")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @CrossOrigin(value = "*")
    @PostMapping("/permissions")
    @Operation(summary = "Create Permission", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreatePermissionRequest.class))
            )
    })
    public Permission createPermission(@RequestBody CreatePermissionRequest createPermissionRequest) {
        return permissionService.createPermission(createPermissionRequest);
    }

    @GetMapping("/permissions/{id}")
    @Operation(summary = "Get Permission By Id", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Permission.class))
            )
    })
    public Permission getPermissionById(@PathVariable(name = "id") Long permissionId) throws UserNotFoundException {
        return permissionService.getPermissionById(permissionId);
    }

    @DeleteMapping("/permissions/{permissionId}")
    @Operation(summary = "Delete Permission By Id", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public String deletePermissionById(@PathVariable long permissionId) {
        permissionService.deletePermissionById(permissionId);
        return "Permission Deleted Successfully";
    }

    @GetMapping("/permissions")
    @Operation(summary = "List Permissions", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public List<Permission> listPermissions(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type
    ) {
        List<Permission> permissions = permissionService.listPermissions(id, name, description, type);
        return permissions;
    }

    @PutMapping("/permissions/{permissionId}")
    @Operation(summary = "Update Permission Request", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdatePermissionRequest.class))
            )
    })
    public Permission updatePermission(@PathVariable long permissionId, @RequestBody UpdatePermissionRequest updatePermissionRequest) {
        return permissionService.updatePermissionRequest(permissionId, updatePermissionRequest);
    }
}