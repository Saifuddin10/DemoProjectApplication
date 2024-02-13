package com.java.saif.DemoProject.models.customer;

import com.java.saif.DemoProject.models.permission.Permission;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "organization", length = 250)
    private String organization;
    @Column(name = "country", length = 250)
    private String country;
    @Column(name = "state", length = 250)
    private String state;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "trademark", length = 250)
    private String tradeMark;
    @OneToMany(targetEntity = Permission.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sub", referencedColumnName = "id")
    private List<Permission> permissions;

    public Customer() {

    }

    public Customer(Long id, String name, String organization, String country,
                    String state, String description, String tradeMark, List<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.country = country;
        this.state = state;
        this.description = description;
        this.tradeMark = tradeMark;
        this.permissions = permissions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
