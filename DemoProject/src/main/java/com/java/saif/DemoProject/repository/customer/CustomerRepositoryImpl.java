package com.java.saif.DemoProject.repository.customer;

import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        Optional<Customer> customer = customerDAO.findById(customerId);
        return customer.get();
    }

    @Override
    public void deleteCustomerById(long customerId) {
        customerDAO.deleteById(customerId);
    }


    @Override
    public List<Customer> listCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.save(customer);
    }
}