package com.java.saif.DemoProject.models.applicationUser;

public class ApplicationUserResponse extends CreateApplicationUserRequest {

    long id;
    long userId;
    long applicationId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }
}
