package com.abc.customer.controller;

import com.abc.customer.entity.Customer;
import com.abc.customer.repository.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/get")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Customer createCustomer(@ModelAttribute Customer customer) {
        return customerRepository.save(customer);
    }


}
