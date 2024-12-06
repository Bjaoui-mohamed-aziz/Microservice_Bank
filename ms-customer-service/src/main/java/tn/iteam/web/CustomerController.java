package tn.iteam.web;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.internal.log.SubSystemLogging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.Customer;
import tn.iteam.exception.CustomerNotFoundException;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {


   //  private static final Logger log = LoggerFactory.getLogger(CustomerController.class);


    private final CustomerRepository customerRepository;


    @GetMapping("/customers/{id}")
    public Customer RetrieveOneCustomer(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with ID " + id + "not found")
        );
        log.info("Customer with ID {} is found", customer.getEmail().toString());
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
