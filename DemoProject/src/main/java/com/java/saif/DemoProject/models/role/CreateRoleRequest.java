package com.java.saif.DemoProject.models.role;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateRoleRequest {
    @NotNull(message = "NAME SHOULD NOT BE NULL")
    @Size(max = 50, message = "LETTERS SHOULD BE 50 ONLY")
    private String name;
    private String description;
    private String type;
    private String displayName;
    private boolean internal;

    public CreateRoleRequest() {
    }

    public CreateRoleRequest(String name, String description, String type, String displayName, boolean internal) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.displayName = displayName;
        this.internal = internal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }
}