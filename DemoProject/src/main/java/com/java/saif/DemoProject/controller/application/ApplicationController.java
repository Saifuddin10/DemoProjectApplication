package com.java.saif.DemoProject.controller.application;

import com.java.saif.DemoProject.models.application.Application;
import com.java.saif.DemoProject.models.application.CreateApplicationRequest;
import com.java.saif.DemoProject.models.application.UpdateApplicationRequest;
import com.java.saif.DemoProject.service.application.ApplicationService;
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
@Tag(name = "Application Controller", description = "Manage Applications in Demo Api")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @CrossOrigin(value = "*")
    @PostMapping("/applications")
    @Operation(summary = "Create Application", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateApplicationRequest.class))
            )
    })
    public Application createApplication(@RequestBody CreateApplicationRequest createApplicationRequest) {
        return applicationService.creteApplication(createApplicationRequest);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/applications/{id}")
    @Operation(summary = "get Application By Id", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = Application.class))
            )
    })
    public Application getApplicationById(@PathVariable(name = "id") long applicationId) {
        Application application = applicationService.getApplicationById(applicationId);
        return new ResponseEntity<>(application, HttpStatus.OK).getBody();
    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/applications/{applicationId}")
    @Operation(summary = "Delete Application", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public String deleteApplicationById(@PathVariable long applicationId) {
        applicationService.deleteApplicationById(applicationId);
        return "Application Deleted Successfully";
    }

    @CrossOrigin(value = "*")
    @GetMapping("/applications")
    @Operation(summary = "List Application", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public ResponseEntity<List<Application>> listApplications(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String displayName,
            @RequestParam(required = false) String loginUrl,
            @RequestParam(required = false) String logoutUrl,
            @RequestParam(required = false) Long version,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) boolean active
    ) {
        List<Application> application = applicationService.listApplications(id, name, displayName, loginUrl, logoutUrl,
                version, description, active);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @CrossOrigin(value = "*")
    @PutMapping("/applications/{applicationId}")
    @Operation(summary = "Update Application", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateApplicationRequest.class))
            )
    })
    public Application updateApplication(@PathVariable long applicationId, @RequestBody UpdateApplicationRequest updateApplicationRequest) {
        return applicationService.updateApplication(applicationId, updateApplicationRequest);
    }
}
