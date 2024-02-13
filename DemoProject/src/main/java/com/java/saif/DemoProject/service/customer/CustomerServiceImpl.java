package com.java.saif.DemoProject.service.customer;

import com.java.saif.DemoProject.models.customer.CreateCustomerRequest;
import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.saif.DemoProject.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setOrganization(createCustomerRequest.getOrganization());
        customer.setCountry(createCustomerRequest.getCountry());
        customer.setState(createCustomerRequest.getState());
        customer.setDescription(createCustomerRequest.getDescription());
        customer.setTradeMark(createCustomerRequest.getTradeMark());
        customer.setPermissions(createCustomerRequest.getPermissions());
        return customerRepository.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public void deleteCustomerById(long customerId) {
         customerRepository.deleteCustomerById(customerId);

    }


    @Override
    public List<Customer> listCustomers() {
        return customerRepository.listCustomers();
    }

    @Override
    public Customer updateCustomer(long customerId, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.getCustomerById(customerId);
        customer.setOrganization(updateCustomerRequest.getOrganization());
        customer.setCountry(updateCustomerRequest.getCountry());
        customer.setState(updateCustomerRequest.getState());
        customer.setDescription(updateCustomerRequest.getDescription());
        customer.setTradeMark(updateCustomerRequest.getTradeMark());
        return customerRepository.updateCustomer(customer);
    }
}
