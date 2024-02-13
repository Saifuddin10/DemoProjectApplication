package com.java.saif.DemoProject.repository;

import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
    List<Customer> findAllByName(String name);

    List<Customer> findAllByOrganization(String organization);

    List<Customer> findAllByCountry(String country);

    List<Customer> findAllByState(String state);

    List<Customer> findAllByDescription(String description);

    List<Customer> findAllByTradeMark(String tradeMark);
}
