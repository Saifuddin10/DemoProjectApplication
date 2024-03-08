package com.java.saif.DemoProject.controller.customer;

import com.java.saif.DemoProject.models.customer.CreateCustomerRequest;
import com.java.saif.DemoProject.models.customer.Customer;
import com.java.saif.DemoProject.models.customer.UpdateCustomerRequest;
import com.java.saif.DemoProject.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Customer Controller", description = "Manage Customers in this Demo API")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(value = "*")
    @PostMapping("/customers")
    @Operation(summary = "Create Customer", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "201",
                    content = @Content(schema = @Schema(implementation = CreateCustomerRequest.class))
            )
    })
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest);
    }

    @CrossOrigin(value = "*")
    @GetMapping("/customers/{id}")
    @Operation(summary = "Create Customer", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Customer.class))
            )
    })
    public Customer getCustomerById(@PathVariable(name = "id") long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @CrossOrigin(value = "*")
    @DeleteMapping("/customers/{customerId}")
    @Operation(summary = "Delete Customer", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public String deleteCustomerById(@PathVariable long customerId) {
        customerService.deleteCustomerById(customerId);
        return "Customer Deleted Successfully";
    }

    @CrossOrigin(value = "*")
    @GetMapping("/customers")
    @Operation(summary = "List Customer", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = void.class))
            )
    })
    public List<Customer> listCustomers() {
        List<Customer> customers = customerService.listCustomers();
        return customers;
    }

    @CrossOrigin(value = "*")
    @PutMapping("/customers/{customerId}")
    @Operation(summary = "Update Customer", responses = {
            @ApiResponse(
                    description = "OK",
                    responseCode = "200",
                    content = @Content(schema = @Schema(implementation = UpdateCustomerRequest.class))
            )
    })
    public Customer updateCustomer(@PathVariable long customerId, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomer(customerId, updateCustomerRequest);
    }
}