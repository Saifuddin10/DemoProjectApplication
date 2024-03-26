package com.java.saif.DemoProject.DAO;

import com.java.saif.DemoProject.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
}