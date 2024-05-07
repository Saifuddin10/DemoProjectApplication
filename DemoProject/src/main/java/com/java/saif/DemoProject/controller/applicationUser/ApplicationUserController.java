package com.java.saif.DemoProject.controller.applicationUser;

import com.java.saif.DemoProject.exception.UserNotFoundException;
import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUser;
import com.java.saif.DemoProject.models.applicationUser.ApplicationUserResponse;
import com.java.saif.DemoProject.models.applicationUser.CreateApplicationUserRequest;
import com.java.saif.DemoProject.models.permission.CreatePermissionRequest;
import com.java.saif.DemoProject.models.user.User;
import com.java.saif.DemoProject.service.applicationUser.ApplicationUserService;
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

import java.util.List;

@RestController
@RequestMapping
@Tag(name = "Application User Controller", description = "Manage Application Users in Demo API")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @CrossOrigin(value = "*")
    @PostMapping("/applicationUsers")
    @Operation(summary = "Create Application Users", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateApplicationUserRequest.class))
            )
    })
    public ApplicationUserResponse createApplicationUser(@RequestBody CreateApplicationUserRequest createApplicationUserRequest) throws UserNotFoundException {
        return applicationUserService.createApplicationUser(createApplicationUserRequest);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/applicationUsers")
    @Operation(summary = "List of Application Users", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = ApplicationUser.class))
            )
    })
    public ResponseEntity<List<Application>> listApplicationsForUser(
            @RequestParam(required = false) String userEmail
    ) {
        List<Application> applicationUsers = applicationUserService.listApplicationsForUser(userEmail);
        return new ResponseEntity<>(applicationUsers, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping(value = "/applicationUsers/{applicationUserId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete Application Users", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public ResponseEntity<String> deleteApplicationUserById(@PathVariable Long applicationUserId) {
        applicationUserService.deleteApplicationUserById(applicationUserId);
        String str = "Application User Deleted Successfully";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}