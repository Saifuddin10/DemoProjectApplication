package com.java.saif.DemoProject.controller.customer;

import com.java.saif.DemoProject.models.customer.CreateCustomerRequest;
import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.saif.DemoProject.models.permission.Permission;
import com.java.saif.DemoProject.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerById(@PathVariable long customerId) {
        customerService.deleteCustomerById(customerId);
        return "Customer Deleted Successfully";
    }

    @GetMapping("/customers")
    public List<Customer> listCustomers() {
        List<Customer> customers = customerService.listCustomers();
        return customers;
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(@PathVariable long customerId, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(customerId, updateCustomerRequest);
    }
}
