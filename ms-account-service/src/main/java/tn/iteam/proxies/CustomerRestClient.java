package tn.iteam.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.iteam.models.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMERS")
public interface CustomerRestClient {


    @GetMapping("/customers/{id}")
    Customer RetrieveOneCustomer(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> RetrieveAllCustomer();


    }
