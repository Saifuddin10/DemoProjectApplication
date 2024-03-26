package com.java.saif.DemoProject.service.customer;

import com.java.saif.DemoProject.models.customer.CreateCustomerRequest;
import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.customer.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CreateCustomerRequest createCustomerRequest);

    Customer getCustomerById(long customerId);

    void deleteCustomerById(long customerId);

    List<Customer> listCustomers();

    Customer updateCustomer(long customerId, UpdateCustomerRequest updateCustomerRequest);
}
