package tn.iteam.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.Customer;
import tn.iteam.exception.CustomerNotFoundException;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class CustomerController {


    private final CustomerRepository customerRepository;


    @GetMapping("/customers/{id}")
    public Customer RetrieveOneCustomer(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with ID " + id + "not found")
        );
        return customer;
    }

    @GetMapping("/customers")
    public List<Customer> RetrieveAllCustomer() {
        List <Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()){
            throw new CustomerNotFoundException("No customer found");
        }
        return null;
    }



}
