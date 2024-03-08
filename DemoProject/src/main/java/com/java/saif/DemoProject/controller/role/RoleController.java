package com.java.saif.DemoProject.controller.role;

import com.java.saif.DemoProject.models.role.CreateRoleRequest;
import com.java.saif.DemoProject.models.role.Role;
import com.java.saif.DemoProject.models.role.UpdateRoleRequest;
import com.java.saif.DemoProject.service.role.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Role Controller", description = "Manage Roles in Demo Api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @CrossOrigin(value = "*")
    @PostMapping("/role")
    @Operation(summary = "Create Role", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateRoleRequest.class))
            )
    })
    public Role createRole(@RequestBody CreateRoleRequest createRoleRequest) {
        return roleService.createRole(createRoleRequest);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/role/{id}")
    @Operation(summary = "getRoleById", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Role.class))
            )
    })
    public Role getRoleById(@PathVariable(name = "id") long roleId) {
        Role role = roleService.getRoleById(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK).getBody();
    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/role/{roleId}")
    @Operation(summary = "Delete Role", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public String deleteRoleById(@PathVariable long roleId) {
        roleService.deleteRoleById(roleId);
        return "Role is deleted Successfully";
    }

    @CrossOrigin(value = "*")
    @GetMapping("/role")
    @Operation(summary = "List Role", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public ResponseEntity<List<Role>> listRoles(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) boolean internal
    ) {
        List<Role> roles = roleService.listRoles(id, name, description, type, displayName, internal);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @PutMapping("/role/{roleId}")
    @Operation(summary = "Update Role", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateRoleRequest.class))
            )
    })
    public Role updateRole(@PathVariable long roleId, @RequestBody UpdateRoleRequest updateRoleRequest) {
        return roleService.updateRole(roleId, updateRoleRequest);
    }
}

