package com.example.backendb.controller;

import com.example.backendb.entity.Customer;
import com.example.backendb.repository.CustomerRepository;
import com.example.backendb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        if(customerService == null) {
            // Log or throw an exception indicating that customerService is null
            System.out.println("Issuueeeeeeeeee");
        }
        customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return null;
    }

    public void setCustomerRepository(CustomerRepository customerRepository1) {
    }
}
