package com.java.saif.DemoProject.models.customer;

import com.java.saif.DemoProject.models.permission.Permission;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class CreateCustomerRequest {
    private String name;
    private String organization;
    private String country;
    private String state;
    private String description;
    private String tradeMark;
    private List<Permission> permissions;

    public CreateCustomerRequest(String name, String organization, String country, String state,
                                 String description, String tradeMark, List<Permission> permissions) {
        this.name = name;
        this.organization = organization;
        this.country = country;
        this.state = state;
        this.description = description;
        this.tradeMark = tradeMark;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
