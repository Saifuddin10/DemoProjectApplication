package com.java.saif.DemoProject.repository.customer;

import com.java.saif.DemoProject.models.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(long customerId);

    void deleteCustomerById(long customerId);

    List<Customer> listCustomers();

    Customer updateCustomer(Customer customer);

}