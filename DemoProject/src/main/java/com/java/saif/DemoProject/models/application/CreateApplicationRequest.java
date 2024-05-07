package com.java.saif.DemoProject.models.application;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateApplicationRequest {

    @NotNull(message = "NAME SHOULD NOT BE NULL")
    @Size(max = 50, message = "LETTERS SHOULD BE 50 ONLY")
    private String name;
    private String displayName;
    private String loginUrl;
    private String logoutUrl;
    private Long version;
    private  String description;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
